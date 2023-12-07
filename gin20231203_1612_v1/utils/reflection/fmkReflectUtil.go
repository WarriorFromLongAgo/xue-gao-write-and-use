package fmkReflectUtil

import (
	"reflect"
)

// 判断对象是否包含指定字段
func hasField(obj interface{}, fieldName string) bool {
	// 使用反射获取对象的类型
	objType := reflect.TypeOf(obj)

	// 获取字段
	_, found := objType.FieldByName(fieldName)
	return found
}
