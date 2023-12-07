package main

import (
	"errors"
	"fmt"
	fmkModel "gin20231203_1612_v1/app/model/common"
	"gin20231203_1612_v1/bootstrap"
	"gin20231203_1612_v1/global"
	fmkTimeUtil "gin20231203_1612_v1/utils/time"
	"github.com/gin-gonic/gin"
	"gorm.io/gorm"
)

func main() {
	// 初始化配置
	bootstrap.InitializeConfig()

	// 初始化日志
	global.App.Log = bootstrap.InitializeLog()
	global.App.Log.Info("log init success!")
	// 初始化数据库
	global.App.DB = bootstrap.InitializeDB()

	// 自定义的 BeforeSave 钩子函数
	MyBeforeSaveHook := func(db *gorm.DB) {
		// 在保存记录之前执行的逻辑
		// 在保存记录之前执行的逻辑
		fmt.Println("Before saving record")

		now := fmkTimeUtil.Now()
		dest := db.Statement.Dest

		//fmkReflectUtil.hasField(dest, fmkModel.CreateUpdate{})

		// 给入参赋值
		if createUpdate, ok := dest.(*fmkModel.CreateUpdate); ok {
			createUpdate.CreatedTime = now
			createUpdate.UpdatedTime = now
		}
	}

	// 自定义的 Before update 钩子函数
	MyBeforeUpdateHook := func(db *gorm.DB) {
		// 在保存记录之前执行的逻辑
		// 在保存记录之前执行的逻辑
		fmt.Println("Before update record")

		now := fmkTimeUtil.Now()
		// 给入参赋值
		if createUpdate, ok := db.Statement.Dest.(*fmkModel.CreateUpdate); ok {
			createUpdate.UpdatedTime = now
		}
	}

	// 注册全局的 BeforeSave 钩子函数
	err := global.App.DB.Callback().Create().Before("gorm:before_save").Register("my:before_save", MyBeforeSaveHook)
	if err != nil {
		global.App.Log.Error("err" + err.Error())
		return
	}
	err2 := global.App.DB.Callback().Update().Before("gorm:before_update").Register("my:before_update", MyBeforeUpdateHook)
	if err != nil {
		global.App.Log.Error("err2 " + err2.Error())
		return
	}

	// 程序关闭前，释放数据库连接
	defer func() {
		if global.App.DB != nil {
			db, _ := global.App.DB.DB()
			err := db.Close()
			if err != nil {
				global.App.Log.Error("db.Close error!")
				return
			}
		}
	}()

	//global.App.Log.Info("Chu_0 11111111111111")
	//err := bootstrap.Chu_0()
	//global.App.Log.Error(err.Error())
	//if err != nil {
	//	global.App.Log.Error("Chu_0 error" + err.Error())
	//	return
	//}

	var a = errors.New("dajdhajda")
	global.App.Log.Error("errors.New " + a.Error())

	bootstrap.InitMySqlTables(global.App.DB)

	//由于在 InitializeValidator() 方法中，使用 RegisterTagNameFunc() 注册了自定义 json tag，
	//所以在 GetMessages() 中自定义错误信息 key 值时，需使用 json tag 名称
	bootstrap.InitializeValidator()

	bootstrap.RunServerV2()
}

func defaultRunServer() {
	r := gin.Default()

	// 启动服务器
	err := r.Run(":" + global.App.Config.App.Port)
	if err != nil {
		return
	}
}
