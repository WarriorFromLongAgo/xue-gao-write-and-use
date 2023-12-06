package controller

import (
	MyValidator "gin20231203_1612_v1/app/request"
	"gin20231203_1612_v1/app/response"
	"gin20231203_1612_v1/business/userinfo/model/dto"
	"gin20231203_1612_v1/business/userinfo/service"
	"gin20231203_1612_v1/global"
	"github.com/gin-gonic/gin"
)

// Register 用户注册
func Register(c *gin.Context) {
	var form dto.Register
	if err := c.ShouldBindJSON(&form); err != nil {
		response.ValidateFail(c, MyValidator.GetErrorMsg(form, err))
		return
	}

	if err, user := service.UserService.Register(form); err != nil {
		global.App.Log.Error(err.Error())
		response.BusinessFail(c, err.Error())
	} else {
		response.Success(c, user)
	}
}
