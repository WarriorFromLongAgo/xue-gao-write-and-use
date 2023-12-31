package struct1

import (
	"fmt"
	"testing"
)

type testStruct struct {
	Test1 int64  `gorm:"column:test1" json:"test1"`
	Test2 string `gorm:"column:test2" json:"test2"`
}

func Test_two_struct(t *testing.T) {
	test1 := testStruct{
		Test1: 1,
		Test2: "11",
	}
	fmt.Println(test1)
}
