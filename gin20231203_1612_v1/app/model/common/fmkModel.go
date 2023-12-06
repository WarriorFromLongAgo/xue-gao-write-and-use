package fmkModel

import (
	"time"
)

// 自增ID主键
type ID struct {
	ID uint `json:"id" gorm:"primaryKey"`
}

// 创建、更新时间
type CreateUpdate struct {
	CreatedBy   uint      `json:"created_by"`
	CreatedTime time.Time `json:"created_time"`
	UpdatedBy   uint      `json:"updated_by"`
	UpdatedTime time.Time `json:"updated_time"`
}

// 软删除
type SoftDeletes struct {
	DelFlag uint `json:"del_flag"`
}
