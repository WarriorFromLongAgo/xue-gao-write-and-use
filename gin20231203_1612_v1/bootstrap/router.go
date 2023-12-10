package bootstrap

import (
	"context"
	"errors"
	"fmt"
	businessRouter "gin20231203_1612_v1/business/userinfo/router"
	"gin20231203_1612_v1/global"
	"gin20231203_1612_v1/middlewares"
	"github.com/gin-gonic/gin"
	"log"
	"net/http"
	"os"
	"os/signal"
	"syscall"
	"time"
)

func setupRouter() *gin.Engine {
	router := gin.Default()

	// 设置跨域中间件
	router.Use(middlewares.Cors())
	router.Use(middlewares.ErrorMiddleware)

	// 前端项目静态资源
	router.StaticFile("/", "./static/dist/index.html")
	router.Static("/assets", "./static/dist/assets")
	router.StaticFile("/favicon.ico", "./static/dist/favicon.ico")
	// 其他静态资源
	router.Static("/public", "./static")
	router.Static("/storage", "./storage/app/public")

	// 注册 api 分组路由
	apiGroup := router.Group("/api")
	businessRouter.SetApiGroupRoutes(apiGroup)

	return router
}

// RunServer 启动服务器
func RunServerV2() {
	r := setupRouter()

	service := &http.Server{
		Addr:    ":" + global.App.Config.App.Port,
		Handler: r,
	}
	go func() {
		if err := service.ListenAndServe(); err != nil && !errors.Is(err, http.ErrServerClosed) {
			log.Fatalf("1111111111111111111111111111111111111111listen: %s\n", err)
		}
	}()

	// 等待中断信号以优雅地关闭服务器（设置 5 秒的超时时间）
	quit := make(chan os.Signal)
	signal.Notify(quit, syscall.SIGINT, syscall.SIGTERM)
	<-quit
	log.Println("Shutdown Server ...")

	// 服务器接收到中止命令后，依旧等待 /api/test 接口完成响应后才停止服务器
	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()
	if err := service.Shutdown(ctx); err != nil {
		log.Fatal("Server Shutdown:", err)
	}
	log.Println("Server exiting")

}

// RunServer 启动服务器
func RunServerV1() {
	r := setupRouter()
	r.Run(":" + global.App.Config.App.Port)
}

func Chu_0() error {
	for i := 0; i < 10; i++ {
		var a = 1 / i
		fmt.Println(a)
		global.App.Log.Info("Chu_0!!!!!!!!!!!!!!")
	}
	return nil
}
