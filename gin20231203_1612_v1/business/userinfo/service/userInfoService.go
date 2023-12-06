package service

import (
	"errors"
	"gin20231203_1612_v1/business/userinfo/model/do"
	"gin20231203_1612_v1/business/userinfo/model/dto"
	"gin20231203_1612_v1/global"
	fmkBcryptUtil "gin20231203_1612_v1/utils/bcrypt"
)

type userService struct {
}

var UserService = new(userService)

// Register 注册
func (userService *userService) Register(params dto.Register) (err error, user do.UserInfo) {
	var result = global.App.DB.Where("mobile = ?", params.Mobile).Select("id").First(&do.UserInfo{})
	if result.RowsAffected != 0 {
		err = errors.New("手机号已存在")
		return
	}
	user = do.UserInfo{Name: params.Name, Mobile: params.Mobile, Password: fmkBcryptUtil.BcryptMake([]byte(params.Password))}
	err = global.App.DB.Create(&user).Error
	return
}
