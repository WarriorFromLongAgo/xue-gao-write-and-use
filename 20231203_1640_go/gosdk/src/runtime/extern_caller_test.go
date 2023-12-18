package runtime

import (
	"fmt"
	"runtime"
	"testing"
)

//runtime.Caller()    获取函数调用栈的某一层栈帧信息
//runtime.Callers()  获取函数调用栈的若干层栈帧信息

func Test_line1(t *testing.T) {
	//foo()
	//fooV2()
	fooV3()
}
func foo() {
	pc, file, line, ok := runtime.Caller(1)
	if ok {
		fmt.Println(runtime.FuncForPC(pc).Name(), file, line)
	}
}

// runtime.Callers一次可以获取调用栈中多个program counter。
// 但是第一个参数skip与上面的runtime.Caller稍有不同，如果传0会获取到Callers函数本身的信息。 传1时才与上面的Caller函数对应。
func fooV2() {
	pc := make([]uintptr, 10)
	n := runtime.Callers(1, pc)
	for i := 0; i < n; i++ {
		f := runtime.FuncForPC(pc[i])
		file, line := f.FileLine(pc[i])
		fmt.Printf("%s %d %s\n", file, line, f.Name())
	}
}

// runtime.CallersFrames可以一次解析多个pc
func fooV3() {
	pc := make([]uintptr, 10)
	n := runtime.Callers(1, pc)
	frames := runtime.CallersFrames(pc[:n])

	var frame runtime.Frame
	more := n > 0
	for more {
		frame, more = frames.Next()
		fmt.Printf("%s %d %s\n", frame.File, frame.Line, frame.Function)
	}
}

//func runtime.FuncForPC(pc uintptr) *runtime.Func
//前面使用了runtime.FuncForPC来解析pc，获得函数信息。
//它返回的*runtime.Func主要有三个方法：
//Entry() uintptr: 返回函数入口地址（函数注释Entry address of the function）
//Name() string: 返回函数名
//FileLine(pc uintptr) (file string, line int): 返回文件名和行号
