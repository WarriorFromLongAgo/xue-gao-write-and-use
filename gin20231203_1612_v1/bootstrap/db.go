package bootstrap

import (
	"fmt"
	"gin20231203_1612_v1/business/userinfo/model/do"
	"gin20231203_1612_v1/global"
	fmkTimeUtil "gin20231203_1612_v1/utils/time"
	"go.uber.org/zap"
	"gopkg.in/natefinch/lumberjack.v2"
	"gorm.io/driver/mysql"
	"gorm.io/gorm"
	"gorm.io/gorm/logger"
	"io"
	"log"
	"os"
	"reflect"
	"strconv"
	"time"
)

func InitializeDB() *gorm.DB {
	// 根据驱动配置进行初始化
	switch global.App.Config.MysqlDatabase.Driver {
	case "mysql":
		return initMySqlGorm()
	default:
		return initMySqlGorm()
	}
}

// 初始化 mysql gorm.DB
func initMySqlGorm() *gorm.DB {
	dbConfig := global.App.Config.MysqlDatabase

	if dbConfig.Database == "" {
		return nil
	}
	dsn := dbConfig.UserName + ":" + dbConfig.Password + "@tcp(" + dbConfig.Host + ":" + strconv.Itoa(dbConfig.Port) + ")/" +
		dbConfig.Database + "?charset=" + dbConfig.Charset + "&parseTime=True&loc=Local"

	global.App.Log.Info("dsn " + dsn)

	mysqlConfig := mysql.Config{
		DSN:                       dsn,   // DSN data source name
		DefaultStringSize:         191,   // string 类型字段的默认长度
		DisableDatetimePrecision:  true,  // 禁用 datetime 精度，MySQL 5.6 之前的数据库不支持
		DontSupportRenameIndex:    true,  // 重命名索引时采用删除并新建的方式，MySQL 5.7 之前的数据库和 MariaDB 不支持重命名索引
		DontSupportRenameColumn:   true,  // 用 `change` 重命名列，MySQL 8 之前的数据库和 MariaDB 不支持重命名列
		SkipInitializeWithVersion: false, // 根据版本自动配置
	}
	if db, err := gorm.Open(mysql.New(mysqlConfig), &gorm.Config{
		DisableForeignKeyConstraintWhenMigrating: true,            // 禁用自动创建外键约束
		Logger:                                   getGormLogger(), // 使用自定义 Logger
	}); err != nil {
		global.App.Log.Error("mysql connect failed, err:", zap.Any("err", err))
		return nil
	} else {
		sqlDB, _ := db.DB()
		sqlDB.SetMaxIdleConns(dbConfig.MaxIdleConns)
		sqlDB.SetMaxOpenConns(dbConfig.MaxOpenConns)
		return db
	}
}

// 自定义 gorm Writer
func getGormLogWriter() logger.Writer {
	var writer io.Writer

	// 是否启用日志文件
	if global.App.Config.MysqlDatabase.EnableFileLogWriter {
		// 自定义 Writer
		writer = &lumberjack.Logger{
			Filename:   global.App.Config.Log.RootDir + "/" + global.App.Config.MysqlDatabase.LogFilename,
			MaxSize:    global.App.Config.Log.MaxSize,
			MaxBackups: global.App.Config.Log.MaxBackups,
			MaxAge:     global.App.Config.Log.MaxAge,
			Compress:   global.App.Config.Log.Compress,
		}
	} else {
		// 默认 Writer
		writer = os.Stdout
	}
	return log.New(writer, "\r\n", log.LstdFlags)
}

func getGormLogger() logger.Interface {
	var logMode logger.LogLevel

	switch global.App.Config.MysqlDatabase.LogMode {
	case "silent":
		logMode = logger.Silent
	case "error":
		logMode = logger.Error
	case "warn":
		logMode = logger.Warn
	case "info":
		logMode = logger.Info
	default:
		logMode = logger.Info
	}

	return logger.New(getGormLogWriter(), logger.Config{
		SlowThreshold:             200 * time.Millisecond,                               // 慢 SQL 阈值
		LogLevel:                  logMode,                                              // 日志级别
		IgnoreRecordNotFoundError: false,                                                // 忽略ErrRecordNotFound（记录未找到）错误
		Colorful:                  !global.App.Config.MysqlDatabase.EnableFileLogWriter, // 禁用彩色打印
	})
}

// 数据库表初始化
func InitMySqlTables(db *gorm.DB) {
	err := db.AutoMigrate(
		do.UserInfo{},
	)
	if err != nil {
		global.App.Log.Error("migrate table failed", zap.Any("err", err))
		os.Exit(0)
	}
}

// 自定义的 BeforeSave 钩子函数
func MyBeforeSaveHook(db *gorm.DB) {
	// 在保存记录之前执行的逻辑
	// 在保存记录之前执行的逻辑
	fmt.Println("Before saving record")

	nowTime := fmkTimeUtil.Now()

	statement := db.Statement
	setGormCreateTime(statement, nowTime)
	setGormUpdateTime(statement, nowTime)
}

// 自定义的 Before update 钩子函数
func MyBeforeUpdateHook(db *gorm.DB) {
	// 在保存记录之前执行的逻辑
	// 在保存记录之前执行的逻辑
	fmt.Println("Before update record")

	nowTime := fmkTimeUtil.Now()

	statement := db.Statement
	setGormUpdateTime(statement, nowTime)
}

func setGormCreateTime(statement *gorm.Statement, nowTime time.Time) {
	dest := statement.Dest

	value := reflect.ValueOf(dest)
	//value  &{{0 0001-01-01 00:00:00 +0000 UTC 0 0001-01-01 00:00:00 +0000 UTC} 111111}
	fmt.Println("setGormCreateTime value ", value)
	valueElem := value.Elem()
	//valueElem  {{0 0001-01-01 00:00:00 +0000 UTC 0 0001-01-01 00:00:00 +0000 UTC} 111111}
	fmt.Println("setGormCreateTime valueElem ", valueElem)

	createUpdateField := valueElem.FieldByName("CreateUpdate")
	if !createUpdateField.IsValid() {
		fmt.Println("setGormCreateTime createUpdateValue 是不合法的")
		return
	}
	fmt.Println("setGormCreateTime createUpdateValue ", createUpdateField.Kind())
	if reflect.Struct != createUpdateField.Kind() {
		return
	}
	createdTimeField := createUpdateField.FieldByName("CreatedTime")
	// Check if the CreatedTime field is valid and can be set
	if createdTimeField.IsValid() && createdTimeField.CanSet() {
		// Modify the CreatedTime value
		//createdTimeField.Set(reflect.ValueOf(newTime))
		statement.SetColumn("CreatedTime", nowTime)
	}
}

func setGormUpdateTime(statement *gorm.Statement, nowTime time.Time) {
	dest := statement.Dest

	value := reflect.ValueOf(dest)
	//value  &{{0 0001-01-01 00:00:00 +0000 UTC 0 0001-01-01 00:00:00 +0000 UTC} 111111}
	fmt.Println("setGormUpdateTime value ", value)
	valueElem := value.Elem()
	//valueElem  {{0 0001-01-01 00:00:00 +0000 UTC 0 0001-01-01 00:00:00 +0000 UTC} 111111}
	fmt.Println("setGormUpdateTime valueElem ", valueElem)

	createUpdateField := valueElem.FieldByName("CreateUpdate")
	if !createUpdateField.IsValid() {
		fmt.Println("createUpdateValue 是不合法的")
		return
	}
	fmt.Println("setGormUpdateTime createUpdateValue ", createUpdateField.Kind())
	if reflect.Struct != createUpdateField.Kind() {
		return
	}

	updatedTimeField := createUpdateField.FieldByName("UpdatedTime")
	// Check if the CreatedTime field is valid and can be set
	if updatedTimeField.IsValid() && updatedTimeField.CanSet() {
		// Modify the CreatedTime value
		//updatedTimeField.Set(reflect.ValueOf(newTime))
		statement.SetColumn("UpdatedTime", nowTime)
	}
}
