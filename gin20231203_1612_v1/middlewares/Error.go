package middlewares

import (
	"gin20231203_1612_v1/app/response"
	"github.com/gin-gonic/gin"
)

func ErrorMiddleware(c *gin.Context) {
	println("=======ErrorMiddleware =111111111111111111111=================")
	defer func() {
		if err := recover(); err != nil {
			// 简单返回友好提示，具体可自定义发生错误后处理逻辑
			//c.JSON(500, gin.H{"msg": "服务器发生错误xxxx"})
			println("=======ErrorMiddleware===2222222222222222222222===============")
			response.FailV2(c, 500, "服务器发生错误xxxx")
			c.Abort()
		}
	}()
	c.Next()
}

//func errorToString(err interface{}) string {
//	switch v := err.(type) {
//	case WrapError:
//		// 符合预期的错误，可以直接返回给客户端
//		return v.Msg
//	case error:
//		// 一律返回服务器错误，避免返回堆栈错误给客户端，实际还可以针对系统错误做其他处理
//		debug.PrintStack()
//		log.Printf("panic: %v\n", v.Error())
//		return "服务器发生错误"
//	default:
//		// 同上
//		return err.(string)
//	}
//}
