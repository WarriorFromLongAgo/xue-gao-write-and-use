package if_else_equal

import (
	"fmt"
	"reflect"
	"testing"
)

//相同类型的值是深度相等的，不同类型的值永远不会深度相等。
//当数组值（array）的对应元素深度相等时，数组值是深度相等的。
//当结构体（struct）值如果其对应的字段（包括导出和未导出的字段）都是深度相等的，则该值是深度相等的。
//当函数（func）值如果都是零，则是深度相等；否则就不是深度相等。
//当接口（interface）值如果持有深度相等的具体值，则深度相等。
//当切片（slice）序号相同，如果值,指针都相等，那么就是深度相等的
//当哈希表（map）相同的key，如果值，指针都相等，那么就是深度相等的。

//通过规则可以知道，reflect.DeepEqual是可以比较struct的，同时也可以用来比较slice和map。

type reflect_DeepEqual_StructA struct {
	Name  string
	Hobby []string
}

func Test_reflect_DeepEqual_Struct(t *testing.T) {
	s1 := reflect_DeepEqual_StructA{Name: "test", Hobby: []string{"唱", "跳"}}
	s2 := reflect_DeepEqual_StructA{Name: "test", Hobby: []string{"唱", "跳"}}
	if reflect.DeepEqual(s1, s2) {
		fmt.Println("struct true")
	}
}

func Test_reflect_DeepEqual_map(t *testing.T) {
	mp1 := map[int]int{1: 10, 2: 20}
	mp2 := map[int]int{1: 10, 2: 20}
	if ok := reflect.DeepEqual(mp1, mp2); ok {
		fmt.Println("mp1 == mp2!")
	} else {
		fmt.Println("mp1 != mp2!")
	}
}
