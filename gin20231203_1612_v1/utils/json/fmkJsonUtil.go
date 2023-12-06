package fmkJsonUtil

import (
	"encoding/json"
	"fmt"
	"gin20231203_1612_v1/global"
)

func Marshal[T interface{}](input T) string {
	marshal, err := json.Marshal(input)
	if err != nil {
		global.App.Log.Error("JsonUtil Marshal" + err.Error())
		return ""
	}
	return string(marshal)
}

func Unmarshal[T interface{}](str string, input T) T {
	err := json.Unmarshal([]byte(str), &input)
	if err != nil {
		fmt.Println("反序列化失败", err)
	}
	return input
}
