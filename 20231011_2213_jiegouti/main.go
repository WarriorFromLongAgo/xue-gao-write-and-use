package main

// "20231011_2213_jiegouti/domain/person2"

import (
	"fmt"
)

type person0 struct {
	name string
	Age  int
	sex  string
}

type UserInfo0 struct {
	name string
	Age  int
	sex  string
}

func (u UserInfo0) PrintInfo() (int, string) {
	fmt.Printf("name = %v, Age = %v", u.sex, u.Age)
	return u.Age, u.name
}

func (u UserInfo0) SetInfo() (int, string) {
	u.name = "111"
	u.Age = 22
	return u.Age, u.name
}

func (u *UserInfo0) SetInfoV2() (int, string) {
	u.name = "111"
	u.Age = 22
	return u.Age, u.name
}

func main() {
	person0Test()
	fmt.Println()
	fmt.Println("==============================================")

	UserInfo0Test()
	fmt.Println()
	fmt.Println("==============================================")

}

func person0Test() {
	var tempPerson1 person0
	tempPerson1.name = "tempPerson1 name"
	// tempPerson1.Age = 1
	tempPerson1.sex = "男"
	fmt.Printf("tempPerson1 的类型：%T, 值：%v", tempPerson1, tempPerson1)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson2 = new(person0)
	tempPerson2.name = "tempPerson2 name"
	// tempPerson2.Age = 2
	// tempPerson2.sex = "男"
	(*tempPerson2).sex = "男"
	fmt.Printf("tempPerson2 的类型：%T, 值：%v", tempPerson2, tempPerson2)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson3 = &person0{}
	tempPerson3.name = "tempPerson3 name"
	// tempPerson3.Age = 3
	// tempPerson2.sex = "男"
	(*tempPerson3).sex = "男"
	fmt.Printf("tempPerson3 的类型：%T, 值：%v", tempPerson3, tempPerson3)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson4 = person0{
		name: "tempPerson4 name",
		// Age:  4,
		sex: "男",
	}
	fmt.Printf("tempPerson4 的类型：%T, 值：%v", tempPerson4, tempPerson4)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson5 = &person0{
		name: "tempPerson5 name",
		// Age:  5,
		sex: "男",
	}
	fmt.Printf("tempPerson5 的类型：%T, 值：%v", tempPerson5, tempPerson5)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson6 = &person0{
		name: "tempPerson6 name",
	}
	fmt.Printf("tempPerson6 的类型：%T, 值：%v", tempPerson6, tempPerson6)
	fmt.Println()
	fmt.Println("==============================================")
}

func UserInfo0Test() {
	var tempPerson1 UserInfo0
	tempPerson1.name = "tempPerson1 name"
	// tempPerson1.Age = 1
	tempPerson1.sex = "男"
	fmt.Printf("tempPerson1 的类型：%T, 值：%v", tempPerson1, tempPerson1)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson2 = new(UserInfo0)
	tempPerson2.name = "tempPerson2 name"
	// tempPerson2.Age = 2
	// tempPerson2.sex = "男"
	(*tempPerson2).sex = "男"
	fmt.Printf("tempPerson2 的类型：%T, 值：%v", tempPerson2, tempPerson2)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson3 = &UserInfo0{}
	tempPerson3.name = "tempPerson3 name"
	// tempPerson3.Age = 3
	// tempPerson2.sex = "男"
	(*tempPerson3).sex = "男"
	fmt.Printf("tempPerson3 的类型：%T, 值：%v", tempPerson3, tempPerson3)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson4 = UserInfo0{
		name: "tempPerson4 name",
		// Age:  4,
		sex: "男",
	}
	fmt.Printf("tempPerson4 的类型：%T, 值：%v", tempPerson4, tempPerson4)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson5 = &UserInfo0{
		name: "tempPerson5 name",
		// Age:  5,
		sex: "男",
	}
	fmt.Printf("tempPerson5 的类型：%T, 值：%v", tempPerson5, tempPerson5)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson6 = &UserInfo0{
		name: "tempPerson6 name",
	}
	fmt.Printf("tempPerson6 的类型：%T, 值：%v", tempPerson6, tempPerson6)
	fmt.Println()
	fmt.Println("==============================================")

	var tempPerson7 = &UserInfo0{
		"tempPerson7 name",
		5,
		"男",
	}
	fmt.Printf("tempPerson7 的类型：%T, 值：%v", tempPerson7, tempPerson7)
	fmt.Println()
	fmt.Println("==============================================")

	tempPerson7.PrintInfo()
	fmt.Println()
	fmt.Println("==============================================")

	tempPerson7.SetInfo()
	tempPerson7.PrintInfo()
	fmt.Println()
	fmt.Println("==============================================")

	tempPerson7.SetInfoV2()
	tempPerson7.PrintInfo()
	fmt.Println()
	fmt.Println("==============================================")
}
