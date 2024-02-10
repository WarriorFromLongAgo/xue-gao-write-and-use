package strings

import (
	"fmt"
	"strings"
	"testing"
)

func Test_str(t *testing.T) {
	str := "Hello, World!"

	// 判断字符串是否包含子串
	fmt.Println(strings.Contains(str, "Hello")) // true

	// 查找子串在字符串中的索引位置
	fmt.Println(strings.Index(str, "World")) // 7

	// 统计子串在字符串中出现的次数
	fmt.Println(strings.Count(str, "o")) // 2

	// 替换字符串中的子串
	newStr := strings.Replace(str, "Hello", "Hi", 1)
	fmt.Println(newStr) // Hi, World!

	// 将字符串分割成切片
	strs := strings.Split(str, ", ")
	fmt.Println(strs) // [Hello World!]

	// 将切片中的字符串连接起来
	joinedStr := strings.Join(strs, " ")
	fmt.Println(joinedStr) // Hello World!

	// 将字符串转换为大写
	fmt.Println(strings.ToUpper(str)) //    HELLO, WORLD!

	// 将字符串转换为小写
	fmt.Println(strings.ToLower(str)) //    hello, world!

	// 去除字符串开头和结尾的空白字符
	trimmedStr := strings.TrimSpace(str)
	fmt.Println(trimmedStr) // Hello, World!

	// 去除字符串开头和结尾的指定字符
	trimmedChar := strings.Trim(str, " H!")
	fmt.Println(trimmedChar) // ello, World

	// 判断字符串是否以指定前缀开头
	fmt.Println(strings.HasPrefix(str, "   ")) // true

	// 判断字符串是否以指定后缀结尾
	fmt.Println(strings.HasSuffix(str, "   ")) // true

	str1 := "Hello"
	str2 := "hello"

	// 不区分大小写地比较字符串是否相等
	fmt.Println(strings.EqualFold(str1, str2)) // true

	// 按照字典顺序比较字符串
	fmt.Println(strings.Compare(str1, str2)) // -1

	// 判断字符串是否以指定前缀开头
	fmt.Println(strings.HasPrefix(str1, "He")) // true

	// 判断字符串是否以指定后缀结尾
	fmt.Println(strings.HasSuffix(str1, "lo")) // true

	//strs1 := []string{"Hello", "World!"}

	// 将切片中的字符串连接起来
	//joinedStr1 := strings.Join(strs1, ", ")
	//fmt.Println(joinedStr) // Hello, World!

	// 将字符串重复多次
	repeatedStr := strings.Repeat("Hello", 3)
	fmt.Println(repeatedStr) // HelloHelloHello

	// 格式化字符串
	formattedStr := fmt.Sprintf("The number is %d", 42)
	fmt.Println(formattedStr) // The number is 42

	tempStr := str[1]
	fmt.Printf("tempStr = %c\n", tempStr)
}
