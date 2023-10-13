package main

import (
	"encoding/json"
	"fmt"
)

// 1, 小写字母开头的属性，不会被json处理
// 2, `json:"age"` {"age":1,"Id":1} 变小写了
type Student struct {
	name string
	Age  int `json:"age"`
	sex  string
	Id   int
}

func main() {
	var student1 = Student{
		name: "name1",
		Age:  1,
		sex:  "nan",
		Id:   1,
	}
	fmt.Printf("student1 = %v", student1)
	fmt.Println()

	jsonByte, error := json.Marshal(student1)
	if error != nil {
		fmt.Println(error)
	}
	jsonStr := string(jsonByte)
	fmt.Println(jsonStr)

	// jsonStr2 := `{"Age":1,"Id":1}`
	jsonStr2 := `{"Age":1,"Id":""}`
	var student2 Student
	error2 := json.Unmarshal([]byte(jsonStr2), &student2)
	if error2 != nil {
		fmt.Println("error2 = ", error2)
	}
	fmt.Printf("student2 = %v", student2)
	fmt.Println()

	fmt.Println("student2 = ", student2)

}
