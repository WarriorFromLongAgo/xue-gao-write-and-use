package do

import (
	fmkModel "gin20231203_1612_v1/app/model/common"
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

//func (userinfo *UserInfo) BeforeSave(db *gorm.DB) (err error) {
//	now := fmkTimeUtil.Now()
//
//	global.App.Log.Info("BeforeSave " + fmkJsonUtil.Marshal(userinfo))
//	userinfo.CreatedTime = now
//	userinfo.UpdatedTime = now
//
//	return
//}

//
//func (userinfo *UserInfo) BeforeUpdate(db *gorm.DB) (err error) {
//	now := fmkTimeUtil.Now()
//
//	global.App.Log.Info("BeforeUpdate " + fmkJsonUtil.Marshal(userinfo))
//	userinfo.UpdatedTime = now
//
//	return
//}
