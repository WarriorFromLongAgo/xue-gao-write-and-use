package error

import (
	"fmt"
	"runtime"
	"testing"
	"time"
)

func Test_stack_v3(t *testing.T) {
	fmt.Printf("Callers address: %p\n", runtime.Callers)
	fmt.Printf("A address: %p\n", A)
	fmt.Printf("B address: %p\n", B)
	go A()
	time.Sleep(1 * time.Second) // 这行要有
}

func A() {
	B()
}

func B() {
	pc := make([]uintptr, 100)
	n := runtime.Callers(0, pc)
	frames := runtime.CallersFrames(pc[:n])
	for i := 0; true; i++ {
		frame, more := frames.Next()
		fmt.Printf("file: %s, line: %d, function: %s, Address: %v\n",
			frame.File, frame.Line, frame.Function, frame.Entry)
		if !more {
			break
		}
	}
}

//————————————————
//版权声明：本文为CSDN博主「dididadida62」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/weixin_62645763/article/details/134024505
