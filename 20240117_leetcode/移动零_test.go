package main

import (
	"fmt"
	"testing"
)

func Test_移动零(t *testing.T) {
	sum1 := []int{0, 0, 0, 1, 0, 3, 12}
	fmt.Println("sum1 切片内容：", sum1)
	moveZeroes(sum1)
	fmt.Println("sum1 切片内容：", sum1)
}

func moveZeroes(nums []int) {
	left, right, n := 0, 0, len(nums)
	for right < n {
		if nums[right] != 0 {
			nums[left], nums[right] = nums[right], nums[left]
			left++
		}
		right++
	}
}
