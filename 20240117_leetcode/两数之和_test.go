package main

import (
	"fmt"
	"testing"
)

// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
// 示例 1：
//
// 输入：nums = [2,7,11,15], target = 9
// 输出：[0,1]
// 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 示例 2：
//
// 输入：nums = [3,2,4], target = 6
// 输出：[1,2]
// 示例 3：
//
// 输入：nums = [3,3], target = 6
// 输出：[0,1]
func Test_v1(t *testing.T) {
	s := []int{2, 7, 11, 15}

	sum1 := twoSum(s, 9)
	fmt.Println("sum1 切片内容：", sum1)
	if sum1[0] == 0 && sum1[1] == 1 {
		t.Log("数据正常")
	} else {
		t.Error("数据异常！！！！！！")
	}
}

func twoSum(nums []int, target int) []int {
	hashTable := map[int]int{}
	for index, value := range nums {
		if tempValue, ok := hashTable[target-value]; ok {
			return []int{tempValue, index}
		}
		hashTable[value] = index
	}
	return nums
}
