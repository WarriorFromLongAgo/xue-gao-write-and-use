package env

import (
	"fmt"
	"os"
	"strings"
	"testing"
)

func Test_env(t *testing.T) {

	os.Setenv("FOO", "1")
	fmt.Println("FOO:", os.Getenv("FOO"))
	fmt.Println("BAR:", os.Getenv("BAR"))

	fmt.Println()
	for _, e := range os.Environ() {
		pair := strings.SplitN(e, "=", 2)
		fmt.Println(pair[0])
	}
}

//$ go run environment-variables.go
//FOO: 1
//BAR:
//
//TERM_PROGRAM
//PATH
//SHELL
//...
//FOO
//
//$ BAR=2 go run environment-variables.go
//FOO: 1
//BAR: 2
//...
