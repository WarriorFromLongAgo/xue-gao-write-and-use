package errors

import (
	"fmt"
	"github.com/pkg/errors"
	"github.com/sirupsen/logrus"
	"testing"
)

func Test_Pkg(t *testing.T) {
	err := errors.Wrap(errors.New("this is an error"), "an error occurred")
	if err != nil {
		logrus.Errorf("logrus Errorf: %+v", err)
	}
	println("===========================================")

	fmt.Printf("fmt Printf: %+v", err)
}
