package main

import (
	"fmt"
	"gin20231203_1612_v1/business/userinfo/model/do"
	fmkJsonUtil "gin20231203_1612_v1/utils/json"
	"testing"
)

func TestMarshal(t *testing.T) {
	str := fmkJsonUtil.Marshal(do.UserInfo{
		Name:   "name",
		Mobile: "1800088",
	})
	fmt.Println("TestMarshal", str)

	//=== RUN   TestMarshal
	//TestMarshal {"id":0,"name":"name","mobile":"1800088","password":"","created_by":0,"created_time":"0001-01-01T00:00:00Z","updated_by":0,"updated_time":"0001-01-01T00:00:00Z","del_flag":0}
	//--- PASS: TestMarshal (0.00s)
}

func TestUnmarshal(t *testing.T) {
	str := "{\"id\":222,\"name\":\"1111111111\",\"mobile\":\"1800088\"}"

	var user do.UserInfo
	domain := fmkJsonUtil.Unmarshal(str, user)
	fmt.Println("TestUnmarshal", fmkJsonUtil.Marshal(domain))

	//=== RUN   TestUnmarshal
	//TestUnmarshal {"id":222,"name":"1111111111","mobile":"1800088","password":"","created_by":0,"created_time":"0001-01-01T00:00:00Z","updated_by":0,"updated_time":"0001-01-01T00:00:00Z","del_flag":0}
	//--- PASS: TestUnmarshal (0.00s)
	//PASS
}
