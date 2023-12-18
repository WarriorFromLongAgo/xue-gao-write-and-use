package _defer

import (
	"fmt"
	"testing"
)

func defer_return() int {
	var a = 1

	defer func() {
		a = a + 1
		println(a)
	}()

	return a
}

func Test_defer(t *testing.T) {
	fmt.Println(defer_return())
}
