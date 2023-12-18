package add

//其中的 import "C" 表示使用了 CGO 。在这条语句前面的注释是一段 C 语言代码。 这里就定义了哪些 C 语言函数被引用。也可以在这里直接编写函数并实现。
//因为这个特殊的语法，import “C” 必须单独一行，不可与其他包一起引用。 可以看到在代码中引用了头文件 add.h 以及 C 标准库的头文件，另外还实现了另一个两数相乘的函数 mul。
import "C"

import (
	"unsafe"
)

func HelloWorld() {
	s := C.CString("Hello World!")
	C.puts(s)
	C.free(unsafe.Pointer(s))
}

func Add(a, b int) int {
	return int(C.add(C.int(a), C.int(b)))
}

func Mul(a, b int) int {
	return int(C.mul(C.int(a), C.int(b)))
}
