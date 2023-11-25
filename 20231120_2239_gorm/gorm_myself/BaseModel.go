package gorm_myself

import "time"

// https://blog.csdn.net/qqMr75/article/details/133743838
// https://www.cnblogs.com/randysun/p/15626722.html
// https://www.cnblogs.com/rickiyang/p/14517120.html

// BaseModel 定义常用模型结构体
type BaseModel struct {
	Id         uint      `gorm:"primaryKey; autoIncrement; not null" json:"id"`
	CreateBy   uint      `gorm:"comment:创建人"`
	CreateTime time.Time `gorm:"autoCreateTime" json:"createTime"`
	UpdateBy   uint      `gorm:"comment:修改人"`
	UpdateTime time.Time `gorm:"autoUpdateTime"`
	DeleteBy   uint      `gorm:"comment:删除人"`
	DeleteTime time.Time `gorm:"autoUpdateTime"`
	DelFlag    uint      `gorm:"not null; default:0; comment:1删除0未删除" json:"delFlag"`
}
