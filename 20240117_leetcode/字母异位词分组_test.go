package main

import (
	"fmt"
	"sort"
	"strings"
	"testing"
)

func Test_字母异位词分组(t *testing.T) {
	strs := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	target := groupAnagrams(strs)
	fmt.Println("target 切片内容：", target)
}

// 示例 1:
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
// 示例 2:
// 输入: strs = [""]
// 输出: [[""]]
// 示例 3:
// 输入: strs = ["a"]
// 输出: [["a"]]
func groupAnagrams(strs []string) [][]string {
	// 创建一个map用于存储排序后的字符串切片
	sortedMap := make(map[string][]string)

	for _, str := range strs {
		charArray := strings.Split(str, "")
		sort.Strings(charArray)
		sortedStr := strings.Join(charArray, "")
		// 将排序后的字符串添加到map的key中
		sortedMap[sortedStr] = append(sortedMap[sortedStr], str)
	}
	// 打印map的内容
	//for key, values := range sortedMap {
	//	fmt.Printf("%s: %v\n", key, values)
	//}
	var values [][]string
	for _, value := range sortedMap {
		values = append(values, value)
	}
	return values
}
