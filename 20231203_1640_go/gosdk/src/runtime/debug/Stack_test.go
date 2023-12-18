package debug

import (
	"fmt"
	"runtime/debug"
	"testing"
)

func Test_stack(t *testing.T) {
	fmt.Println("--- BEGIN ---")
	fmt.Println(string(debug.Stack()))
	fmt.Println("--- END ---")
}
