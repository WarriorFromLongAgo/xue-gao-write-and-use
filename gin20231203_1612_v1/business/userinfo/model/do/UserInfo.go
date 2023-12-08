package userInfoDo

import (
	"errors"
	fmkModel "gin20231203_1612_v1/app/model/common"
	"gin20231203_1612_v1/business/userinfo/model/dto"
	"gin20231203_1612_v1/global"
	fmkBcryptUtil "gin20231203_1612_v1/utils/bcrypt"
)

type UserInfo struct {
	fmkModel.ID
	Name     string `json:"name" gorm:"not null;comment:用户名称"`
	Mobile   string `json:"mobile" gorm:"not null;index;comment:用户手机号"`
	Password string `json:"password" gorm:"not null;default:'';comment:用户密码"`
	fmkModel.CreateUpdate
	fmkModel.SoftDeletes
}

// TableName 将 User 的表名设置为 `profiles`
func (UserInfo) TableName() string {
	return "user_info"
}

func GetByMobile(dto dto.RegisterDTO) (UserInfo, error) {
	var result UserInfo
	var dbResult = global.App.DB.Where("mobile = ?", dto.Mobile).Select("id").First(&result)
	if dbResult.RowsAffected != 0 {
		return UserInfo{}, errors.New("手机号已存在")
	}
	return result, nil
}

func CreateFunc(params dto.RegisterDTO) (UserInfo, error) {
	user := UserInfo{Name: params.Name, Mobile: params.Mobile, Password: fmkBcryptUtil.BcryptMake([]byte(params.Password))}
	var dbResult = global.App.DB.Create(&user)

	if dbResult.RowsAffected != 0 {
		return UserInfo{}, errors.New("手机号已存在")
	}
	return user, nil
}
