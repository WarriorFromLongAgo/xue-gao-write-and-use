package main

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
)

func main() {
	str1 := `
		str str
					str str
		str str
	`
	fmt.Println("str1 = ", str1)
	// str1 =
	// str str
	// 				str str
	// str str

	var rune1 = 'a'
	// rune1 =  97
	fmt.Println("rune1 = ", rune1)
	fmt.Printf("rune2 = %c \n", rune1)

	strArr1 := strings.Split("1-1-1", "-")
	fmt.Printf("strArr1: %v\n", strArr1)
	fmt.Printf("strArr2: %v\n", strings.Join(strArr1, "=="))

	bool1 := strings.Contains("username2", "2")
	fmt.Printf("Contains: %v\n", bool1)

	str2 := "str2"
	for i := 0; i < len(str2); i++ {
		fmt.Printf("ascii 1 = %v", str2[i])
		fmt.Println()
		fmt.Printf("ascii 2 = %c", str2[i])
		fmt.Println()
	}

	fmt.Println("============================")
	for k, v := range str2 {
		// fmt.Println("k =", k, ",v = ", v)
		fmt.Printf("k = %v, v = %c", k, v)
		fmt.Println()
	}

	// fmt.Println("============================")
	// changeStr()

	// fmt.Println("============================")
	// funcStrconv()

	// fmt.Println("============================")
	// ifElse()

	// fmt.Println("============================")
	// arrDeal()

	// fmt.Println("============================")
	// sortDeal()

	fmt.Println("============================")
	mapDeal()

}

func changeStr() {
	str1 := "str1"
	byteS1 := []byte(str1)
	fmt.Println("changeStr, byteS1, ", byteS1)
	fmt.Println("changeStr, byteS1, ", string(byteS1))
	byteS1[0] = 'S'
	fmt.Println("changeStr, byteS1, ", string(byteS1))

	str2 := "str2"
	runeS1 := []rune(str2)
	fmt.Println("changeStr, runeS1, ", runeS1)
	fmt.Println("changeStr, runeS1, ", string(runeS1))
	runeS1[0] = 'S'
	fmt.Println("changeStr, runeS1, ", string(runeS1))

}

func funcStrconv() {
	// 1, FormatInt
	int1 := 2
	str1 := strconv.FormatInt(int64(int1), 10)
	fmt.Println("funcStrconv, str1, ", str1)
	str2 := strconv.FormatInt(int64(int1), 2)
	fmt.Println("funcStrconv, str2, ", str2)

	// 2, FormatFloat
	f1 := 22.2
	// 参数1, 要转换的值
	// 参数2, 格式化的类型，
	// 'f' (-ddd.ddddd)
	// 参数3, 保留的小数点
	// 参数4, 格式化的类型
	str3 := strconv.FormatFloat(f1, 'f', 2, 64)
	fmt.Println("funcStrconv, str3, ", str3)

	var int2, _ = strconv.ParseInt("1234", 10, 64)
	fmt.Println("funcStrconv, int2, ", int2)

	var float1, _ = strconv.ParseFloat("1234.1234", 64)
	fmt.Println("funcStrconv, float1, ", float1)

	var float2, _ = strconv.ParseFloat("1234.1234xxxxx", 64)
	fmt.Println("funcStrconv, float2, ", float2)
	// 这里返回的是0
}

func ifElse() {
	bool1 := true
	if bool1 {
		fmt.Println("ifElse, true true ", bool1)
	}

	age1 := 30
	if age1 > 20 {
		fmt.Println("ifElse, age1 > 20, ", age1 > 20)
		fmt.Println("ifElse, age1 , ", age1)
	}
	fmt.Println("ifElse, age1 , ", age1)

	// 局部变量
	if age2 := 30; age2 > 20 {
		fmt.Println("ifElse, age2 > 20, ", age2 > 20)
		fmt.Println("ifElse, age2 , ", age2)
	}
	// fmt.Println("ifElse, age2 , ", age2)

	age3 := 85
	if age3 > 95 {
		fmt.Println("ifElse, age3 > 95, ", age3 > 95)
	} else if age3 > 85 {
		fmt.Println("ifElse, age3 > 85, ", age3 > 85)
	} else {
		fmt.Println("ifElse, age3 <= 85, ", age3 <= 85)
	}

	pingfen := "D"
	switch pingfen {
	case "A", "B", "C":
		fmt.Println("ifElse, pingfen ", "ABC")
	case "D":
		fmt.Println("ifElse, pingfen ", "D")
	}

	// fallthrough 穿透一层
	pingfen2 := "B"
	switch pingfen2 {
	case "A":
		fmt.Println("ifElse, pingfen2 ", "A")
	case "B":
		fmt.Println("ifElse, pingfen2 ", "B")
		fallthrough
	case "C":
		fmt.Println("ifElse, pingfen2 ", "C")
	case "D":
		fmt.Println("ifElse, pingfen2 ", "D")
	}

label1:
	for i := 0; i < 10; i++ {
		for j := 0; j < 10; j++ {
			if j == 3 {
				break label1
			}
			fmt.Printf("ifElse, label1 i = %v, j = %v", i, j)
			fmt.Println()
		}
	}

label2:
	for i := 0; i < 10; i++ {
		for j := 0; j < 10; j++ {
			if j == 3 {
				continue label2
			}
			fmt.Printf("ifElse, label2 i = %v, j = %v", i, j)
			fmt.Println()
		}
	}

	int1 := 111
	if int1 > 100 {
		fmt.Println("ifElse, label3 a ")
		fmt.Println("ifElse, label3 b ")
		goto label3
	}
	fmt.Println("ifElse, label3 1 ")
	fmt.Println("ifElse, label3 2 ")
label3:
	fmt.Println("ifElse, label3 3 ")
	fmt.Println("ifElse, label3 4 ")

}

// 这种是数组，，[]里面有值
// var intArr1 [3]int
// var intArr3 = [...]int{1, 3, 4, 5, 6}

// 这种是切片，，[]这里面没有值
// var intArr1 []int

func arrDeal() {
	var intArr1 [3]int
	fmt.Println("arrDeal intArr1 = ", intArr1)
	var intArr2 = [4]int{1, 3, 4, 5}
	fmt.Println("arrDeal intArr2 = ", intArr2)
	var strArr1 [4]string
	fmt.Println("arrDeal strArr1 = ", strArr1)
	var intArr3 = [...]int{1, 3, 4, 5, 6}
	fmt.Println("arrDeal intArr3 = ", intArr3)
	var intArr4 = [...]int{0: 1, 3: 3, 5: 50, 6: 70}
	fmt.Println("arrDeal intArr4 = ", intArr4)

	arr1 := []string{"11", "22", "33"}
	fmt.Println("arr1 = ", arr1)
	fmt.Println("arr2 = ", strings.Join(arr1, "-="))

	for i := 0; i < len(arr1); i++ {
		fmt.Println("arrDeal arr1 = ", arr1[i])
	}

	for key, v := range arr1 {
		fmt.Println("arrDeal arr1 key = ", key, ", v = ", v)
	}

	fmt.Println("============================")

	var intArr10 = [...]int{1, 3, 4, 5, 6}
	var intArr11 = intArr10
	fmt.Println("arrDeal intArr10 = ", intArr10)
	fmt.Println("arrDeal intArr11 = ", intArr11)
	intArr11[0] = 100
	fmt.Println("arrDeal intArr10 = ", intArr10)
	fmt.Println("arrDeal intArr11 = ", intArr11)

	fmt.Println("============================")
	var intArr12 = []int{1, 3, 4, 5, 6}
	var intArr13 = intArr12
	fmt.Println("arrDeal intArr12 = ", intArr12)
	fmt.Println("arrDeal intArr13 = ", intArr13)
	intArr12[0] = 100
	fmt.Println("arrDeal intArr12 = ", intArr12)
	fmt.Println("arrDeal intArr13 = ", intArr13)

	fmt.Println("============================")
	var intArr14 = []int{1, 3, 4, 5, 6}
	var intArr15 = intArr14
	fmt.Println("arrDeal intArr14 = ", intArr14)
	fmt.Println("arrDeal intArr15 = ", intArr15)
	intArr15[0] = 100
	fmt.Println("arrDeal intArr14 = ", intArr14)
	fmt.Println("arrDeal intArr15 = ", intArr15)

	fmt.Println("============================")
	var intArr16 = []int{1, 3, 4, 5, 6}
	fmt.Printf("arrDeal intArr16 %v %T 长度=%v ", intArr16, intArr16, len(intArr16))

	fmt.Println("============================")
	var intArr17 = []int{1, 3, 4, 5, 6}
	var intArr18 []int
	fmt.Println("arrDeal intArr17 = ", intArr17)
	fmt.Println("arrDeal intArr18 = ", intArr18)
	fmt.Println("arrDeal intArr17 = nil = ", intArr17 == nil)
	fmt.Println("arrDeal intArr18 = nil = ", intArr18 == nil)

	fmt.Println("============================")
	var intArr19 = [5]int{1, 3, 4, 5, 6}
	var intArr20 = intArr19[:]
	fmt.Printf("arrDeal intArr19 %v %T 长度=%v ", intArr19, intArr19, len(intArr19))
	fmt.Println()
	fmt.Printf("arrDeal intArr20 %v %T 长度=%v ", intArr20, intArr20, len(intArr20))
	fmt.Println()
	fmt.Printf("arrDeal intArr20 %v %T 长度=%v 容量=%v", intArr20, intArr20, len(intArr20), cap(intArr20))
	fmt.Println()

	fmt.Println("============================")
	// 长度位4，容量为8
	var intArr21 = make([]int, 4, 8)
	fmt.Printf("arrDeal intArr21 %v %T 长度=%v 容量=%v", intArr21, intArr21, len(intArr21), cap(intArr21))
	fmt.Println()

	fmt.Println("============================")
	// 切面的扩容
	var intArr22 []int
	// 默认长度是0，容量是0
	fmt.Printf("arrDeal intArr22 %v %T 长度=%v 容量=%v", intArr22, intArr22, len(intArr22), cap(intArr22))
	fmt.Println()
	intArr22 = append(intArr22, 10)
	// 默认长度是1，容量是1
	fmt.Printf("arrDeal intArr22 %v %T 长度=%v 容量=%v", intArr22, intArr22, len(intArr22), cap(intArr22))
	fmt.Println()

	fmt.Println("============================")
	// 切面的扩容，追加
	var intArr23 = []int{1, 2}
	var intArr24 = []int{11, 33}
	fmt.Printf("arrDeal intArr23 %v %T 长度=%v 容量=%v", intArr23, intArr23, len(intArr23), cap(intArr23))
	fmt.Println()
	fmt.Printf("arrDeal intArr24 %v %T 长度=%v 容量=%v", intArr24, intArr24, len(intArr24), cap(intArr24))
	fmt.Println()
	intArr25 := append(intArr23, intArr24...)
	fmt.Printf("arrDeal intArr25 %v %T 长度=%v 容量=%v", intArr25, intArr25, len(intArr25), cap(intArr25))
	fmt.Println()

	fmt.Println("============================")
	// 切面的扩容，追加
	var intArr26 = []int{1, 2, 3, 4, 5, 6, 7, 8}
	fmt.Printf("arrDeal intArr26 %v %T 长度=%v 容量=%v", intArr26, intArr26, len(intArr26), cap(intArr26))
	fmt.Println()
	var intArr27 = make([]int, len(intArr26))
	// var intArr27 = make([]int, 2, 2)
	fmt.Printf("arrDeal intArr27 %v %T 长度=%v 容量=%v", intArr27, intArr27, len(intArr27), cap(intArr27))
	fmt.Println()
	copy(intArr27, intArr26)
	fmt.Printf("arrDeal intArr27 %v %T 长度=%v 容量=%v", intArr27, intArr27, len(intArr27), cap(intArr27))
	fmt.Println()
	intArr27[0] = 1111
	fmt.Printf("arrDeal intArr26 %v %T 长度=%v 容量=%v", intArr26, intArr26, len(intArr26), cap(intArr26))
	fmt.Println()
	fmt.Printf("arrDeal intArr27 %v %T 长度=%v 容量=%v", intArr27, intArr27, len(intArr27), cap(intArr27))
	fmt.Println()

	fmt.Println("============================")
	var intArr28 = []int{1, 2, 3, 4, 5, 6, 7, 8}
	// 删除 3
	var intArr29 = append(intArr28[:2], intArr28[3:]...)
	fmt.Printf("arrDeal intArr29 %v %T 长度=%v 容量=%v", intArr29, intArr29, len(intArr29), cap(intArr29))
	fmt.Println()

}

func sortDeal() {
	fmt.Println("============================")
	intList := []int{1, 3, 4535, 32, 432, 56767, 234, 89}
	sort.Ints(intList)
	fmt.Println("sortDeal intList ", intList)
	sort.Sort(sort.Reverse(sort.IntSlice(intList)))
	fmt.Println("sortDeal intList Reverse ", intList)

	fmt.Println("============================")
	strList := []string{"1", "3", "4535", "32", "432", "56767", "234", "89"}
	sort.Strings(strList)
	fmt.Println("sortDeal strList ", strList)
	sort.Sort(sort.Reverse(sort.StringSlice(strList)))
	fmt.Println("sortDeal strList Reverse ", strList)

}

func mapDeal() {
	fmt.Println("============================")
	var userMap = make(map[string]string)
	userMap["username"] = "xuegao"
	// userMap["age"] = 22
	userMap["age"] = "222"
	fmt.Println("mapDeal userMap ", userMap)
	fmt.Println("mapDeal userMap username ", userMap["username"])

	fmt.Println("============================")
	var userMap2 = map[string]string{
		"username": "xuegao",
		"age":      "22",
	}
	userMap2["username222"] = "xuegao222"
	fmt.Println("mapDeal userMap2 ", userMap2)

	for key, v := range userMap2 {
		fmt.Println("mapDeal userMap2 for range ", key, v)
	}

	userMap2["username"] = "xuegao==============xuegao"
	fmt.Println("mapDeal userMap2 ", userMap2)

	fmt.Println("============================")
	// 包含某个值
	value1, flag1 := userMap2["username"]
	fmt.Println("mapDeal userMap2 username = ", value1, flag1)
	value2, flag2 := userMap2["username22234343"]
	fmt.Println("mapDeal userMap2 username = ", value2, flag2)

	fmt.Println("============================")
	var userMap3 = map[string]string{
		"username": "xuegao",
		"age":      "11",
		"age2":     "22",
		"age3":     "33",
	}
	fmt.Println("mapDeal userMap3 ", userMap3)
	delete(userMap3, "age2")
	fmt.Println("mapDeal userMap3 ", userMap3)

	fmt.Println("============================")
	userInfoArr := make([]map[string]string, 3, 3)
	if userInfoArr[0] == nil {
		userInfoArr[0] = make(map[string]string)
		userInfoArr[0]["username"] = "xuegao0"
		userInfoArr[0]["age"] = "00"
	}
	if userInfoArr[1] == nil {
		userInfoArr[1] = make(map[string]string)
		userInfoArr[1]["username"] = "xuegao1"
		userInfoArr[1]["age"] = "11"
	}
	fmt.Println("mapDeal userInfoArr ", userInfoArr)
	// for key1, v1 := range userInfoArr {
	// }

	fmt.Println("============================")
	var userMap4 = map[string]string{
		"username": "xuegao",
		"age":      "11",
		"age2":     "22",
		"age3":     "33",
	}
	keys := make([]string, 0, len(userMap4))
	for k := range userMap4 {
		keys = append(keys, k)
	}
	for index, value1 := range keys {
		fmt.Println("mapDeal userMap4 index ", index, value1, userMap4[value1])
	}

}
