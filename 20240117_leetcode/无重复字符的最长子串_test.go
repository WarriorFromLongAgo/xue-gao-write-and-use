package main

import (
	"fmt"
	"testing"
)

func Test_无重复字符的最长子串(t *testing.T) {
	input := "abcabcbb"
	ans := lengthOfLongestSubstringV2(input)
	fmt.Println("input 内容：", input)
	fmt.Println("ans ：", ans)
}

func lengthOfLongestSubstringV2(s string) int {
	left, maxLen := 0, 0
	m := make(map[int32]int, 0)
	for right, v := range s {
		if i, ok := m[v]; ok {
			for _, k := range s[left : m[v]+1] {
				delete(m, k)
			}
			left = i + 1
		}
		m[v] = right
		maxLen = max(maxLen, right-left+1)
	}
	return maxLen
}

//作者：喵酱不熬夜
//链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/2254613/shi-jian-ji-bai-liao-10000-de-yong-hu-da-94fp/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

func lengthOfLongestSubstring(s string) int {
	start, tmp, res := 0, 0, 0
	for i := 0; i < len(s); i++ {
		tmp = i - start + 1
		for j := start; j < i; j++ {
			left := s[i]
			right := s[j]
			if left == right {
				tmp = i - start
				start = j + 1
				break
			}
		}
		if tmp > res {
			res = tmp
		}
	}
	return res
}

//作者：__jinchen__
//链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
