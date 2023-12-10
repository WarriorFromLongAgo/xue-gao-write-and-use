package controller

import (
	"errors"
	MyValidator "gin20231203_1612_v1/app/request"
	"gin20231203_1612_v1/app/response"
	"gin20231203_1612_v1/business/userinfo/model/dto"
	"gin20231203_1612_v1/business/userinfo/service"
	"gin20231203_1612_v1/global"
	"github.com/gin-gonic/gin"
)

// Register 用户注册
func Register(c *gin.Context) {
	var form dto.RegisterDTO
	if err := c.ShouldBindJSON(&form); err != nil {
		response.Fail(c, MyValidator.GetErrorMsg(form, err))
		return
	}
	user, err := service.UserService.Register(form)
	if err != nil {
		global.App.Log.Error(err.Error())
		response.Fail(c, err.Error())
		return
	}
	response.Success(c, user)
}

// TestError 用户注册
func TestError(c *gin.Context) {
	tempInt := newError()

	println("============================")
	response.Success(c, tempInt)
}

func newError() int {
	panic(errors.New("账号或密码错误"))

	return 1
}
