package slices

import (
	"fmt"
	"testing"
)

func Test_for_Slices_test(t *testing.T) {
	nums := []int{0, 1, 0, 3, 12}

	for index, value := range nums {
		fmt.Println("sum1 切片内容：", index, value)
	}
}
