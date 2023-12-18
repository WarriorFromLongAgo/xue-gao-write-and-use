package _0231217_2117

import (
	"fmt"
	"testing"
)

func Test_forrange(t *testing.T) {
	var prints []func()
	for i := 1; i <= 3; i++ {
		prints = append(prints, func() { fmt.Println(i) })
	}
	for _, print := range prints {
		print()
	}
}

//4
//4
//4
// 这里返回的444，就很奇怪
//2023 1217 2118

func Test_forrange_go(t *testing.T) {
	done := make(chan bool)

	values := []string{"a", "b", "c"}
	for _, v := range values {
		go func() {
			fmt.Println(v)
			done <- true
		}()
	}

	// wait for all goroutines to complete before exiting
	for _ = range values {
		<-done
	}
}

//c
//c
//c
// 这里返回的ccc，就很奇怪
//2023 1217 2118
