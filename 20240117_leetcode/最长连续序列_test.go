package main

import (
	"fmt"
	"testing"
)

func Test_最长连续序列(t *testing.T) {
	s := []int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}
	length := longestConsecutive(s)
	fmt.Println(length)
}

func longestConsecutive(nums []int) int {
	numMap := map[int]bool{}
	for _, v := range nums {
		numMap[v] = true
	}

	maxLength := 0
	for key, _ := range numMap {
		if !numMap[key-1] {
			curLength := 1
			for numMap[key+1] {
				curLength++
				key++
			}
			if curLength > maxLength {
				maxLength = curLength
			}
		}
	}
	return maxLength
}
