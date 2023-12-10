package main

import "20231120_2239_gorm/gorm_myself"

// godemo get github.com/godemo-sql-driver/mysql
// godemo get github.com/jmoiron/sqlx

func main() {
	// gorm_myself.Gorm_test()

	// gorm_myself.BaseModel_1_test()

	// gorm_myself.BaseModel_1_c()
	//gorm_myself.BaseModel_1_c_v2()
	gorm_myself.BaseModel_1_c_v3()

	//gorm_myself.BaseModel_1_r()

}

// type User struct {
// 	gorm.Model
// 	Name string
// 	Age  int
// }

// func main() {
// 	dsn := "root:123456@tcp(127.0.0.1:3306)/go_mysql?charset=utf8mb4&parseTime=True&loc=Local"
// 	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})
// 	if err != nil {
// 		panic("failed to connect database")
// 	}
// 	db.AutoMigrate(&User{})

// 	// 使用引用对象
// 	userRef := &User{Name: "John", Age: 25}
// 	resultRef := db.Create(userRef)
// 	fmt.Printf("Reference Object: %+v\n", userRef)
// 	fmt.Printf("RowsAffected: %d\n", resultRef.RowsAffected)

// 	// 使用值对象
// 	userVal := User{Name: "Jane", Age: 30}
// 	resultVal := db.Create(userVal)
// 	fmt.Printf("Value Object: %+v\n", userVal)
// 	fmt.Printf("RowsAffected: %d\n", resultVal.RowsAffected)
// }

// func main() {
// user := User{Name: "John", Age: 25}

// 	// 调用接收值的方法
// 	changeAge(user)
// 	fmt.Println("After changeAge:", user)

// 	// 调用接收引用的方法
// 	changeAge2(&user)
// 	fmt.Println("After changeAge2:", user)
// }

// func changeAge(user User) {
// 	// 对 user 进行操作，不会影响原始对象
// 	user.Age = user.Age + 1
// 	fmt.Println("Inside changeAge:", user)
// }

// func changeAge2(user *User) {
// 	// 对 user 进行操作，会影响原始对象
// 	user.Age = user.Age + 1
// 	fmt.Println("Inside changeAge2:", *user)
// }
