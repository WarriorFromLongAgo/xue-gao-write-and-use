package gorm_myself

import (
	"fmt"
	"time"

	"gorm.io/driver/mysql"
	"gorm.io/gorm"
)

type BaseModel_1 struct {
	BaseModel
	Username string     `gorm_myself:"column:username11; type:varchar(100); comment:姓名"`
	Time1    time.Time  `gorm_myself:"null; type:varchar(100); comment:time1"`
	Time2    *time.Time `gorm_myself:"null; type:varchar(100); comment:time2"`
}

// TableName 将 User 的表名设置为 `profiles`
func (BaseModel_1) TableName() string {
	return "Base_Model_1"
}

func BaseModel_1_test() {
	dsn := "root:123456@tcp(127.0.0.1:3306)/go_mysql?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

	if err != nil {
		fmt.Println("database open failed ,err=", err)
		return
	}

	//创建表 自动迁移 （把结构体和数据表进行对应 ）
	err = db.AutoMigrate(&BaseModel_1{})
	if err != nil {
		fmt.Println("database AutoMigrate failed ,err=", err)
		return
	}

}

func BaseModel_1_c() {
	dsn := "root:123456@tcp(127.0.0.1:3306)/go_mysql?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

	if err != nil {
		fmt.Println("BaseModel_1_c database open failed ,err=", err)
		return
	}

	model := &BaseModel_1{Username: "Jinzhu", Time1: time.Now(), Time2: nil}
	model.Time2 = &model.Time1

	// 使用 Create 方法创建记录
	result := db.Create(model)
	// 打印创建的对象的值
	if result.Error != nil {
		fmt.Println("Create record failed, err=", result.Error)
	} else {
		fmt.Printf("Created Model: %+v\n", *model)
		fmt.Printf("Created result: %+v\n", *result)
		fmt.Printf("Created Config: %+v\n", *result.Config)
		fmt.Printf("Created RowsAffected: %+v\n", result.RowsAffected)
	}

	modelArr := []*BaseModel_1{
		{Username: "111111", Time1: time.Now(), Time2: nil},
		{Username: "222222", Time1: time.Now(), Time2: nil},
	}
	resultArr := db.Create(modelArr)
	// 打印创建的对象数组的值
	if resultArr.Error != nil {
		fmt.Println("Create records failed, err=", resultArr.Error)
	} else {
		fmt.Printf("Created result: %+v\n", *resultArr)
		fmt.Printf("Created Config: %+v\n", *resultArr.Config)
		fmt.Printf("Created RowsAffected: %+v\n", resultArr.RowsAffected)

		fmt.Println("Created Models:")
		for _, m := range modelArr {
			fmt.Printf("m == %+v\n", *m)
		}
	}
	//Created Model: {BaseModel:{Id:13 CreateBy:0 CreateTime:2023-11-24 22:05:39.107 +0800 CST UpdateBy:0 UpdateTime:2023-11-24 22:05:39.107 +0800 CST DeleteBy:0 DeleteTime:2023-11-24 22:05:39.107 +0800 CST DelFlag:0} Username:Jinzhu Time1:2023-11-24 22:05:39.1061896 +0800 CST m=+0.009088401 Time2:2023-11-24 22:05:39.1061896 +0800 CST m=+0.009088401}
	//Created result: {Config:0xc0001745a0 Error:<nil> RowsAffected:1 Statement:0xc0001a41c0 clone:0}
	//Created Config: {SkipDefaultTransaction:false NamingStrategy:{TablePrefix: SingularTable:false NameReplacer:<nil> NoLowerCase:false IdentifierMaxLength:64} FullSaveAssociations:false Logger:0xc0001743f0 NowFunc:0x813a00 DryRun:false PrepareStmt:false DisableAutomaticPing:false DisableForeignKeyConstraintWhenMigrating:false IgnoreRelationshipsWhenMigrating:false DisableNestedTransaction:false AllowGlobalUpdate:false QueryFields:false CreateBatchSize:0 TranslateError:false ClauseBuilders:maps[ON CONFLICT:0x813060 VALUES:0x8136e0] ConnPool:0xc00008f1e0 Dialector:0xc00008ca38 Plugins:maps[] callbacks:0xc00008ca48 cacheStore:0xc00013bc80}
	//Created RowsAffected: 1
	//Created result: {Config:0xc0001745a0 Error:<nil> RowsAffected:2 Statement:0xc000230000 clone:0}
	//Created Config: {SkipDefaultTransaction:false NamingStrategy:{TablePrefix: SingularTable:false NameReplacer:<nil> NoLowerCase:false IdentifierMaxLength:64} FullSaveAssociations:false Logger:0xc0001743f0 NowFunc:0x813a00 DryRun:false PrepareStmt:false DisableAutomaticPing:false DisableForeignKeyConstraintWhenMigrating:false IgnoreRelationshipsWhenMigrating:false DisableNestedTransaction:false AllowGlobalUpdate:false QueryFields:false CreateBatchSize:0 TranslateError:false ClauseBuilders:maps[ON CONFLICT:0x813060 VALUES:0x8136e0] ConnPool:0xc00008f1e0 Dialector:0xc00008ca38 Plugins:maps[] callbacks:0xc00008ca48 cacheStore:0xc00013bc80}
	//Created RowsAffected: 2
	//Created Models:
	//m == {BaseModel:{Id:14 CreateBy:0 CreateTime:2023-11-24 22:05:39.153 +0800 CST UpdateBy:0 UpdateTime:2023-11-24 22:05:39.153 +0800 CST DeleteBy:0 DeleteTime:2023-11-24 22:05:39.153 +0800 CST DelFlag:0} Username:111111 Time1:2023-11-24 22:05:39.1523578 +0800 CST m=+0.055256601 Time2:<nil>}
	//m == {BaseModel:{Id:15 CreateBy:0 CreateTime:2023-11-24 22:05:39.153 +0800 CST UpdateBy:0 UpdateTime:2023-11-24 22:05:39.153 +0800 CST DeleteBy:0 DeleteTime:2023-11-24 22:05:39.153 +0800 CST DelFlag:0} Username:222222 Time1:2023-11-24 22:05:39.1523578 +0800 CST m=+0.055256601 Time2:<nil>}

	// 指定字段创建
	// db.Select("Name", "Age", "CreatedAt").Create(&user)

	// 忽略传递给 ‘Omit’ 的字段值，然后创建
	// db.Omit("Name", "Age", "CreatedAt").Create(&user)
	// INSERT INTO `users` (`birthday`,`updated_at`) VALUES ("2020-01-01 00:00:00.000", "2020-07-04 11:05:21.775")

}

// 也可以
func BaseModel_1_c_v2() {
	dsn := "root:123456@tcp(127.0.0.1:3306)/go_mysql?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

	if err != nil {
		fmt.Println("BaseModel_1_c_v2 database open failed ,err=", err)
		return
	}

	modelArr := []BaseModel_1{
		{Username: "111111", Time1: time.Now(), Time2: nil},
		{Username: "222222", Time1: time.Now(), Time2: nil},
	}
	resultArr := db.Create(modelArr)
	// 打印创建的对象数组的值
	if resultArr.Error != nil {
		fmt.Println("BaseModel_1_c_v2 Create records failed, err=", resultArr.Error)
	} else {
		fmt.Printf("BaseModel_1_c_v2 Created result: %+v\n", *resultArr)
		fmt.Printf("BaseModel_1_c_v2 Created Config: %+v\n", *resultArr.Config)
		fmt.Printf("BaseModel_1_c_v2 Created RowsAffected: %+v\n", resultArr.RowsAffected)

		fmt.Println("BaseModel_1_c_v2 Created Models:")
		for _, m := range modelArr {
			fmt.Printf("m == %+v\n", m)
		}
	}
}

// 也可以
// 增加全局拦截器
func BaseModel_1_c_v3() {
	dsn := "root:123456@tcp(127.0.0.1:3306)/go_mysql?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

	if err != nil {
		fmt.Println("BaseModel_1_c_v2 database open failed ,err=", err)
		return
	}
	// 自定义的 BeforeSave 钩子函数
	MyBeforeSaveHook := func(db *gorm.DB) {
		// 在保存记录之前执行的逻辑
		// 在保存记录之前执行的逻辑
		fmt.Println("Before saving record")

		//now := time.Now()
		//dest := db.Statement.Dest
	}
	// 注册全局的 BeforeSave 钩子函数
	err2 := db.Callback().Create().Before("gorm:before_save").Register("my:before_save", MyBeforeSaveHook)
	if err2 != nil {
		fmt.Println(" err2 ", err2.Error())
		return
	}

	modelArr := []BaseModel_1{
		{Username: "111111", Time1: time.Now(), Time2: nil},
		{Username: "222222", Time1: time.Now(), Time2: nil},
	}
	resultArr := db.Create(modelArr)
	// 打印创建的对象数组的值
	if resultArr.Error != nil {
		fmt.Println("BaseModel_1_c_v2 Create records failed, err=", resultArr.Error)
	} else {
		fmt.Printf("BaseModel_1_c_v2Created result: %+v\n", *resultArr)
		fmt.Printf("BaseModel_1_c_v2 Created Config: %+v\n", *resultArr.Config)
		fmt.Printf("BaseModel_1_c_v2 Created RowsAffected: %+v\n", resultArr.RowsAffected)

		fmt.Println("BaseModel_1_c_v2 Created Models:")
		for _, m := range modelArr {
			fmt.Printf("m == %+v\n", m)
		}
	}
}

func (model *BaseModel_1) BeforeSave(tx *gorm.DB) (err error) {
	fmt.Println("BeforeSave========================")

	return
}

func (model *BaseModel_1) BeforeCreate(tx *gorm.DB) (err error) {
	fmt.Println("BeforeCreate========================")

	return
}

func (model *BaseModel_1) AfterCreate(tx *gorm.DB) (err error) {
	fmt.Println("AfterCreate========================")

	return
}
func (model *BaseModel_1) AfterSave(tx *gorm.DB) (err error) {
	fmt.Println("AfterSave========================")

	return
}

func (model *BaseModel_1) AfterFind(tx *gorm.DB) (err error) {
	fmt.Println("AfterFind========================", model)
	return
}

func BaseModel_1_r() {
	dsn := "root:123456@tcp(127.0.0.1:3306)/go_mysql?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

	if err != nil {
		fmt.Println("BaseModel_1_c database open failed ,err=", err)
		return
	}

	model := &BaseModel_1{Username: "Jinzhu", Time1: time.Now(), Time2: nil}

	db.Table("Base_Model_1").Select("id", "username11").Where("username11 = ?", "111111").Scan(&model)
	fmt.Println("BaseModel_1_c, model =", model)

	// Raw SQL
	db.Raw("SELECT id, username11 FROM Base_Model_1 WHERE username11 = ?", "111111").Scan(&model)
	fmt.Println("BaseModel_1_c, model =", model)

}
