package error

import (
	"errors"
	"fmt"
	"testing"
)

func Test_stack_失败(t *testing.T) {
	//var f float64 = 1.1
	var f float64 = -1.1
	sqrt, err := Sqrt(f)
	if err != nil {
		println("err = ", err.Error())
	}
	println("sqrt = ", sqrt)

	//var f float64 = 1.1
	var f2 float64 = -1.1
	sqrt2, err2 := SqrtV2(f2)
	if err2 != nil {
		println("err2 = ", err2.Error())
	}
	println("sqrt2 = ", sqrt2)
}

func Sqrt(f float64) (float64, error) {
	if f < 0 {
		return 0, errors.New("math: square root of negative number")
	}
	return f, nil
}

func SqrtV2(f float64) (float64, error) {
	if f < 0 {
		return 0, fmt.Errorf("math: square root of negative number %g", f)
	}
	return f, nil
}
