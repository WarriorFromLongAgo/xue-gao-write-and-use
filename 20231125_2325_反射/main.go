package main

import (
	"fmt"
	"reflect"
	"time"
)

func main() {
	// reflect_type()

	// reflect_value()

	// reflect_set_value()

	//u := User{1, "zs", 20}
	//Poni(u)
	//PoniV2(u)

	//SetValue(&u)
	//fmt.Println(u)
	// CallMethod(u)

	//var s Student
	//GetTag(&s)

	//fieldType, err := getFieldType(u, "Id")
	//if err != nil {
	//	return
	//}
	//fmt.Println(fieldType)

	//IsValidTest()

	user := &UserInfo{
		Username: "111111",
	}
	setGormCrateAndUpdate(user)
}

// 创建、更新时间
type CreateUpdate struct {
	CreatedBy   uint      `json:"created_by"`
	CreatedTime time.Time `json:"created_time"`
	UpdatedBy   uint      `json:"updated_by"`
	UpdatedTime time.Time `json:"updated_time"`
}

type UserInfo struct {
	CreateUpdate
	Username string `gorm_myself:"column:username11; type:varchar(100); comment:姓名"`
}

func setGormCrateAndUpdate(info *UserInfo) {
	newTime := time.Now() // For example, add 24 hours to the current time

	value := reflect.ValueOf(info)
	//value  &{{0 0001-01-01 00:00:00 +0000 UTC 0 0001-01-01 00:00:00 +0000 UTC} 111111}
	fmt.Println("value ", value)
	valueElem := value.Elem()
	//valueElem  {{0 0001-01-01 00:00:00 +0000 UTC 0 0001-01-01 00:00:00 +0000 UTC} 111111}
	fmt.Println("valueElem ", valueElem)

	createUpdateField := valueElem.FieldByName("CreateUpdate")
	if !createUpdateField.IsValid() {
		fmt.Println("createUpdateValue 是不合法的")
		return
	}
	fmt.Println("createUpdateValue ", createUpdateField.Kind())
	if reflect.Struct != createUpdateField.Kind() {
		return
	}
	createdTimeField := createUpdateField.FieldByName("CreatedTime")
	// Check if the CreatedTime field is valid and can be set
	if createdTimeField.IsValid() && createdTimeField.CanSet() {
		// Modify the CreatedTime value
		createdTimeField.Set(reflect.ValueOf(newTime))
	}

	updatedTimeField := createUpdateField.FieldByName("UpdatedTime")
	// Check if the CreatedTime field is valid and can be set
	if updatedTimeField.IsValid() && updatedTimeField.CanSet() {
		// Modify the CreatedTime value
		updatedTimeField.Set(reflect.ValueOf(newTime))
	}

	fmt.Println("info的值", *info)
}

func IsValidTest() {
	u := User{Id: 1, Name: "zs"}

	// 获取类型
	t := reflect.TypeOf(u)
	fmt.Println("结构体类型：", t)
	fmt.Println("结构体名字：", t.Name())
	// 获取值
	v := reflect.ValueOf(u)
	fmt.Println("结构体的值：", v)

	//createUpdateField := reflect.ValueOf(u).FieldByName("CreateUpdate")
	//fmt.Println("结构体的 createUpdateField ：", createUpdateField)
	//createUpdateField.IsValid()

	// 可以获取所有属性
	// 获取结构体字段个数：t.NumField()
	for i := 0; i < t.NumField(); i++ {
		// 取每个字段
		val := v.Field(i)
		fmt.Println("val :", val.IsValid())
	}
	//结构体类型： main.User
	//结构体名字： User
	//结构体的值： {1 zs 0}
	//val : true
	//val : true
	//val : true

}

// 获取变量的类型
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

// 获取变量值的信息
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

// 修改变量值的信息
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

// 获取结构体的属性名，属性值，属性类型，，打印结构体的方法名
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
		fmt.Printf("%s : %v \n", f.Name, f.Type)
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

// 单纯 获取结构体的类型
func PoniV2(o interface{}) {
	t := reflect.TypeOf(o)
	// 可以获取所有属性
	// 获取结构体字段个数：t.NumField()
	for i := 0; i < t.NumField(); i++ {
		// 取每个字段
		f := t.Field(i)
		fmt.Printf("%s : %v ====\n", f.Name, f.Type)
		// 获取字段的值信息
	}
}

// 修改结构体值
func SetValue(o interface{}) {
	v := reflect.ValueOf(o)
	// 获取指针指向的元素
	v = v.Elem()
	// 取字段
	//f := v.FieldByName("Name")
	//if f.Kind() == reflect.String {
	//	f.SetString("kuteng")
	//}
}

// 调用结构体的方法
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

// 获取获取结构体的tag
func GetTag(u interface{}) {
	v := reflect.ValueOf(u)
	// 类型
	t := v.Type()
	// 获取字段
	f := t.Elem().Field(0)
	fmt.Println(f.Tag.Get("json"))
	fmt.Println(f.Tag.Get("db"))
}

// 获取结构体字段的类型
func getFieldType(obj interface{}, fieldName string) (string, error) {
	// 使用反射获取对象的类型
	objType := reflect.TypeOf(obj)

	// 获取字段
	field, found := objType.FieldByName(fieldName)
	if !found {
		return reflect.Invalid.String(), fmt.Errorf("field %s not found", fieldName)
	}

	// 获取字段的类型
	return field.Type.Kind().String(), nil
}

// 判断对象是否包含指定字段
func hasField(obj interface{}, fieldName string) bool {
	// 使用反射获取对象的类型
	objType := reflect.TypeOf(obj)

	// 获取字段
	_, found := objType.FieldByName(fieldName)
	return found
}
