package slices

import (
	"fmt"
	"testing"
)

func Test_init_Slices(t *testing.T) {
	Ids1 := make([]int64, 10)
	fmt.Println("Ids1切片长度：", len(Ids1))
	fmt.Println("Ids1切片容量：", cap(Ids1))
	fmt.Println("Ids1切片内容：", Ids1)

	Ids2 := make([]int64, 0, 10)
	fmt.Println("Ids2切片长度：", len(Ids2))
	fmt.Println("Ids2切片容量：", cap(Ids2))
	fmt.Println("Ids2切片内容：", Ids2)

	Ids3 := []int{0, 1, 2, 3, 4, 5, 6, 7, 8}
	fmt.Println("Ids3切片长度：", len(Ids3))
	fmt.Println("Ids3切片容量：", cap(Ids3))
	fmt.Println("Ids3切片内容：", Ids3)

}
