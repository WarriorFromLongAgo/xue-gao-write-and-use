package mysql

import (
	"database/sql"
	"time"
)

func mysql_test() {
	// jdbc:mysql://localhost:3306/go_mysql?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false

	db, err := sql.Open("mysql", "root:123456@tcp(127.0.0.1:3306)/go_mysql")
	if err != nil {
		panic(err)
	}
	db.SetConnMaxLifetime(time.Minute * 3)
	db.SetMaxOpenConns(10)
	db.SetMaxIdleConns(10)

}
