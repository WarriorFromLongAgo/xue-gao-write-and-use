package error

import (
	"errors"
	"fmt"
	"runtime"
	"testing"
)

func TestWrapError(t *testing.T) {
	err := errors.New("you are wrong")
	//err = WrapError("oneWrap", err)
	err = WrapError("twoWrap", err)
	fmt.Print(err)
}

func TestWrapError_v1(t *testing.T) {
	err := errors.New("you are wrong")
	err = WrapError_V1("twoWrap", err)
	fmt.Printf("fmt Printf: %+v", err)
}

func TestGetErrorStack(t *testing.T) {
	err := errors.New("I am an error")
	fmt.Println(GetErrorStack("real an error", err))
}

func WrapError(wrapMsg string, err error) error {
	pc, file, line, ok := runtime.Caller(3)
	f := runtime.FuncForPC(pc)
	if !ok {
		return errors.New("WrapError 方法获取堆栈失败")
	}
	if err == nil {
		return nil
	} else {
		errMsg := fmt.Sprintf("%s \n\tat %s:%d (Method %s)\nCause by: %s\n", wrapMsg, file, line, f.Name(), err.Error())
		return errors.New(errMsg)
	}
}

type stack []uintptr

func WrapError_V1(wrapMsg string, err error) error {
	const depth = 32
	var pcs [depth]uintptr
	n := runtime.Callers(3, pcs[:])
	fmt.Printf("fmt Printf: %+v", n)
	var st stack = pcs[0:n]
	fmt.Printf("fmt Printf: %+v", st)
	return err
}

func GetErrorStack(preStr string, err error) string {
	pc, file, line, ok := runtime.Caller(1)
	f := runtime.FuncForPC(pc)
	if !ok {
		return "GetErrorStack 方法获取堆栈失败，返回错误原信息：" + err.Error()
	}
	if err == nil {
		return ""
	} else {
		errMsg := fmt.Sprintf("%s \n\tat %s:%d (Method %s)\nCause by: %s\n", preStr, file, line, f.Name(), err.Error())
		return errMsg
	}
}
