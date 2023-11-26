package main

import (
	"fmt"
	"reflect"
)

func main() {
	// reflect_type()

	// reflect_value()

	// reflect_set_value()

	// u := User{1, "zs", 20}
	// Poni(u)

	// SetValue(&u)
	// fmt.Println(u)
	// CallMethod(u)

	var s Student
	GetTag(&s)
}

func reflect_type() {
	var x float64 = 3.4

	t := reflect.TypeOf(x)
	fmt.Println("类型是：", t)
	// kind()可以获取具体类型
	k := t.Kind()
	fmt.Println(k)
	switch k {
	case reflect.Float64:
		fmt.Printf("a is float64\n")
	case reflect.String:
		fmt.Println("string")
	}

	// 类型是： float64
	// float64
	// a is float64
}

// 反射获取interface值信息
func reflect_value() {
	var a float64 = 3.4

	v := reflect.ValueOf(a)
	fmt.Println(v)
	k := v.Kind()
	fmt.Println(k)
	switch k {
	case reflect.Float64:
		fmt.Println("a是：", v.Float())
	}

	// 3.4
	// float64
	// a是： 3.4
}

// 反射修改值
func reflect_set_value() {
	var a float64 = 3.4
	fmt.Println("main:", a)

	v := reflect.ValueOf(&a)
	k := v.Kind()
	switch k {
	case reflect.Float64:
		// 反射修改值
		v.SetFloat(6.9)
		fmt.Println("a is ", v.Float())
	case reflect.Ptr:
		// Elem()获取地址指向的值
		v.Elem().SetFloat(7.9)
		fmt.Println("case:", v.Elem().Float())
		// 地址
		fmt.Println(v.Pointer())
	}

	fmt.Println("main:", a)
}

// 定义结构体
type User struct {
	Id   int
	Name string
	Age  int
}

// 绑方法
func (u User) Hello(name string) {
	fmt.Println("Hello !!!!!!!!!!!!!!!!!!!! ", name)
}

// 传入interface{}
func Poni(o interface{}) {
	t := reflect.TypeOf(o)
	fmt.Println("类型：", t)
	fmt.Println("字符串类型：", t.Name())
	// 获取值
	v := reflect.ValueOf(o)
	fmt.Println(v)
	// 可以获取所有属性
	// 获取结构体字段个数：t.NumField()
	for i := 0; i < t.NumField(); i++ {
		// 取每个字段
		f := t.Field(i)
		fmt.Printf("%s : %v", f.Name, f.Type)
		// 获取字段的值信息
		// Interface()：获取字段对应的值
		val := v.Field(i).Interface()
		fmt.Println("val :", val)
	}
	fmt.Println("=================方法====================")
	for i := 0; i < t.NumMethod(); i++ {
		m := t.Method(i)
		fmt.Println(m.Name)
		fmt.Println(m.Type)
	}

}

// 修改结构体值
func SetValue(o interface{}) {
	v := reflect.ValueOf(o)
	// 获取指针指向的元素
	v = v.Elem()
	// 取字段
	f := v.FieldByName("Name")
	if f.Kind() == reflect.String {
		f.SetString("kuteng")
	}
}

// 调用方法，需要传入方法的参数
func CallMethod(u interface{}) {
	v := reflect.ValueOf(u)
	// 获取方法
	m := v.MethodByName("Hello")
	// 构建一些参数
	args := []reflect.Value{reflect.ValueOf("6666")}
	// 没参数的情况下：var args2 []reflect.Value
	// 调用方法，需要传入方法的参数
	m.Call(args)
}

type Student struct {
	Name string `json:"name1" db:"name2"`
}

// 获取字段的tag
func GetTag(u interface{}) {
	v := reflect.ValueOf(u)
	// 类型
	t := v.Type()
	// 获取字段
	f := t.Elem().Field(0)
	fmt.Println(f.Tag.Get("json"))
	fmt.Println(f.Tag.Get("db"))
}
