package gorm_myself

import (
	"fmt"

	"gorm.io/driver/mysql"
	"gorm.io/gorm"
)

// create table person_gorms
// (
//
//	username   longtext    null,
//	sex        longtext    null,
//	email      longtext    null,
//	id         bigint unsigned auto_increment
//	    primary key,
//	created_at datetime(3) null,
//	updated_at datetime(3) null,
//	deleted_at datetime(3) null
//
// );
// create index idx_person_gorms_deleted_at
//
//	on person_gorms (deleted_at);
type PersonGorm struct {
	Username string `gorm_myself:"column:username;type:varchar(100);comment:姓名"`
	Sex      string `gorm_myself:"type:varchar(100);comment:姓名"`
	Email    string `gorm_myself:"type:varchar(100);comment:姓名"`
	gorm.Model
}

// TableName 将 User 的表名设置为 `profiles`
func (PersonGorm) TableName() string {
	return "profiles"
}

func Gorm_test() {
	dsn := "root:123456@tcp(127.0.0.1:3306)/go_mysql?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

	if err != nil {
		fmt.Println("database open failed ,err=", err)
		return
	}

	//创建表 自动迁移 （把结构体和数据表进行对应 ）
	err = db.AutoMigrate(&PersonGorm{})
	if err != nil {
		fmt.Println("database AutoMigrate failed ,err=", err)
		return
	}

}
