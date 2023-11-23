package gorm

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
	Username string `db:"username"`
	Sex      string `db:"sex"`
	Email    string `db:"email"`
	gorm.Model
}

func Gorm_test() {
	dsn := "root:123456@tcp(127.0.0.1:3306)/go_mysql?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

	if err != nil {
		fmt.Println("database open failed ,err=", err)
		return
	}
	//创建表 自动迁移 （把结构体和数据表进行对应 ）
	db.AutoMigrate(&PersonGorm{})

}
