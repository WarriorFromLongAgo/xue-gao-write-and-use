package response

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

// 响应结构体
type Response struct {
	Code    int    `json:"code"`    // 自定义错误码
	Data    any    `json:"data"`    // 数据
	Message string `json:"message"` // 信息
}

// Success 响应成功 ErrorCode 为 0 表示成功
func Success(c *gin.Context, data any) {
	c.JSON(http.StatusOK, Response{
		http.StatusOK,
		data,
		"ok",
	})
}

// Fail 响应失败 ErrorCode 不为 0 表示失败
func Fail(c *gin.Context, msg string) {
	c.JSON(http.StatusOK, Response{
		http.StatusInternalServerError,
		nil,
		msg,
	})
}

// Fail 响应失败 ErrorCode 不为 0 表示失败
func FailV2(c *gin.Context, code int, msg string) {
	c.JSON(http.StatusOK, Response{
		code,
		nil,
		msg,
	})
}
