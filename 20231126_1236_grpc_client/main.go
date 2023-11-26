package main

// golang写RPC程序，必须符合4个基本条件，不然RPC用不了
// 结构体字段首字母要大写，可以别人调用
// 函数名必须首字母大写
// 函数第一参数是接收参数，第二个参数是返回给客户端的参数，必须是指针类型
// 函数还必须有一个返回值error

import (
	"fmt"
	"log"
	"net/rpc"
)

// 传的参数
type Params struct {
	Width, Height int
}

// 主函数
func main() {
	// 1.连接远程rpc服务
	conn, err := rpc.DialHTTP("tcp", ":8000")
	if err != nil {
		log.Fatal(err)
	}
	// 2.调用方法
	// 面积
	ret := 0
	err2 := conn.Call("Rect.Area", Params{50, 100}, &ret)
	if err2 != nil {
		log.Fatal(err2)
	}
	fmt.Println("面积：", ret)
	// 周长
	err3 := conn.Call("Rect.Perimeter", Params{50, 100}, &ret)
	if err3 != nil {
		log.Fatal(err3)
	}
	fmt.Println("周长：", ret)
}
