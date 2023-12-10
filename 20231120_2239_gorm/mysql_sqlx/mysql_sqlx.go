package mysqlsqlx

import (
	"fmt"
	"time"

	_ "github.com/godemo-sql-driver/mysql"
	"github.com/jmoiron/sqlx"
)

var Db *sqlx.DB

type Person struct {
	UserId   int    `db:"user_id"`
	Username string `db:"username"`
	Sex      string `db:"sex"`
	Email    string `db:"email"`
}

func Mysql_sqlx() {
	// jdbc:mysql://localhost:3306/go_mysql?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false

	database, err := sqlx.Open("mysql", "root:123456@tcp(127.0.0.1:3306)/go_mysql")
	if err != nil {
		fmt.Println("open mysql failed,", err)
		return
	}
	database.SetConnMaxLifetime(time.Minute * 3)
	database.SetMaxOpenConns(10)
	database.SetMaxIdleConns(10)
	Db = database
}

func Mysql_sqlx_CR() {
	// 新增方法
	r, err := Db.Exec("insert into person(username, sex, email)values(?, ?, ?)", "stu001", "man", "stu01@qq.com")
	if err != nil {
		fmt.Println("mysql_sqlx_CRUD exec failed, ", err)
		return
	}
	id, err := r.LastInsertId()
	if err != nil {
		fmt.Println("mysql_sqlx_CRUD LastInsertId exec failed, ", err)
		return
	}
	fmt.Println("insert succ:", id)

	// 查询方法
	var person []Person
	err = Db.Select(&person, "select user_id, username, sex, email from person where user_id=?", 1)
	if err != nil {
		fmt.Println("exec failed, ", err)
		return
	}

	fmt.Println("select succ:", person)
}

func Mysql_sqlx_U() {
	// 查询方法
	var person []Person
	err := Db.Select(&person, "select user_id, username, sex, email from person where user_id=?", 1)
	if err != nil {
		fmt.Println("exec failed, ", err)
		return
	}
	res, err := Db.Exec("update person set username=? where user_id=?", "stu0001111", 1)
	if err != nil {
		fmt.Println("exec failed, ", err)
		return
	}
	row, err := res.RowsAffected()
	if err != nil {
		fmt.Println("rows failed, ", err)
	}
	fmt.Println("update succ:", row)
}

func Mysql_sqlx_D() {
	res, err := Db.Exec("delete from person where user_id=?", 1)
	if err != nil {
		fmt.Println("exec failed, ", err)
		return
	}

	row, err := res.RowsAffected()
	if err != nil {
		fmt.Println("rows failed, ", err)
	}

	fmt.Println("delete succ: ", row)
}

func Mysql_sqlx_transaction() {
	// 1） import (“github.com/jmoiron/sqlx")
	// 2)  Db.Begin()        开始事务
	// 3)  Db.Commit()        提交事务
	// 4)  Db.Rollback()     回滚事务

	conn, err := Db.Begin()
	if err != nil {
		fmt.Println("begin failed :", err)
		return
	}

	r, err := conn.Exec("insert into person(username, sex, email)values(?, ?, ?)", "stu001", "man", "stu01@qq.com")
	if err != nil {
		fmt.Println("exec failed, ", err)
		conn.Rollback()
		return
	}
	id, err := r.LastInsertId()
	if err != nil {
		fmt.Println("exec failed, ", err)
		conn.Rollback()
		return
	}
	fmt.Println("insert succ:", id)

	r, err = conn.Exec("insert into person(username, sex, email)values(?, ?, ?)", "stu001", "man", "stu01@qq.com")
	if err != nil {
		fmt.Println("exec failed, ", err)
		conn.Rollback()
		return
	}
	id, err = r.LastInsertId()
	if err != nil {
		fmt.Println("exec failed, ", err)
		conn.Rollback()
		return
	}
	fmt.Println("insert succ:", id)

	conn.Commit()
}
