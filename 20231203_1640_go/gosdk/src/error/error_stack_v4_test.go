package error

import (
	"fmt"
	"runtime/debug"
	"testing"
)

func Test_stack_v4(t *testing.T) {
	boom()
}

func foo() {
	fmt.Println("--- BEGIN ---")
	fmt.Println(string(debug.Stack()))
	fmt.Println("--- END ---")

}

func boom() {
	foo()
}
