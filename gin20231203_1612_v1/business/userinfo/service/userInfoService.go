package service

import (
	"errors"
	userInfoDo "gin20231203_1612_v1/business/userinfo/model/do"
	"gin20231203_1612_v1/business/userinfo/model/dto"
)

type userService struct {
}

var UserService = new(userService)

// Register 注册
func (userService *userService) Register(params dto.RegisterDTO) (user userInfoDo.UserInfo, err error) {
	_, err = userInfoDo.GetByMobile(params)
	if err == nil {
		// 如果没有异常，那么就是有查到数据
		return userInfoDo.UserInfo{}, errors.New("手机号已存在")
	}
	// 如果有异常，那么就是没有查到数据，可以新增

	createFunc, err := userInfoDo.CreateFunc(params)
	if err != nil {
		return userInfoDo.UserInfo{}, err
	}
	return createFunc, err
}
