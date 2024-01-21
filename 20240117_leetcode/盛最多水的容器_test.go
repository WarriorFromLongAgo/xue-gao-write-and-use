package main

import (
	"fmt"
	"testing"
)

func Test_盛最多水的容器(t *testing.T) {
	inputArr := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	ans := maxArea(inputArr)
	fmt.Println("sum1 切片内容：", inputArr)
	fmt.Println("ans ：", ans)
}

func maxArea(height []int) (ans int) {
	left, right := 0, len(height)-1
	for left < right {
		area := (right - left) * min(height[left], height[right])
		ans = max(ans, area)
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return ans
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
