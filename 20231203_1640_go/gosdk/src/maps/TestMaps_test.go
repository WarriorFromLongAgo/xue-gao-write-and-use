package maps

import (
	"fmt"
	"testing"
)

func Test_init_map(t *testing.T) {
	// 创建一个空的 Map
	m := make(map[string]int)
	fmt.Println("map:", m)
	fmt.Println("len:", len(m))

	// 创建一个初始容量为 10 的 Map
	m2 := make(map[string]int, 10)
	fmt.Println("map:", m2)
	fmt.Println("len:", len(m2))
}
