package if_else_equal

import (
	"fmt"
	"github.com/google/go-cmp/cmp"
	"github.com/google/go-cmp/cmp/cmpopts"
	"math"
	"testing"
)

type Contact struct {
	Phone string
	Email string
}

type User struct {
	Name    string
	Age     int
	Contact *Contact
}

func Test_go_cmp(t *testing.T) {
	u1 := User{Name: "dj", Age: 18}
	u2 := User{Name: "dj", Age: 18}

	fmt.Println("u1 == u2?", u1 == u2)
	fmt.Println("u1 equals u2?", cmp.Equal(u1, u2))
	fmt.Println("=================================")

	c1 := &Contact{Phone: "123456789", Email: "dj@example.com"}
	c2 := &Contact{Phone: "123456789", Email: "dj@example.com"}
	fmt.Println("=================================")

	u1.Contact = c1
	u2.Contact = c1
	fmt.Println("u1 == u2 with same pointer?", u1 == u2)
	fmt.Println("u1 equals u2 with same pointer?", cmp.Equal(u1, u2))
	fmt.Println("=================================")

	u2.Contact = c2
	fmt.Println("u1 == u2 with different pointer?", u1 == u2)
	fmt.Println("u1 equals u2 with different pointer?", cmp.Equal(u1, u2))
	fmt.Println("=================================")
}

func Test_go_cmp_panic(t *testing.T) {
	c1 := &Contact{Phone: "123456789", Email: "dj@example.com"}
	c2 := &Contact{Phone: "123456789", Email: "dj@example.com"}

	u1 := User{"dj", 18, c1}
	u2 := User{"dj", 18, c2}

	fmt.Println("u1 equals u2?", cmp.Equal(u1, u2))
}

type FloatPair struct {
	X float64
	Y float64
}

// 我们知道，计算机中浮点数的表示是不精确的，如果涉及到运算，可能会产生误差累计。
// 此外，还有一个特殊的浮点数NaN（Not a Number），它与任何浮点数都不等，包括它自己。这样，有时候会出现一些反直觉的结果：
func Test_FloatPair(t *testing.T) {
	p1 := FloatPair{X: math.NaN()}
	p2 := FloatPair{X: math.NaN()}
	fmt.Println("p1 equals p2?", cmp.Equal(p1, p2))

	f1 := 0.1
	f2 := 0.2
	f3 := 0.3
	p3 := FloatPair{X: f1 + f2}
	p4 := FloatPair{X: f3}
	fmt.Println("p3 equals p4?", cmp.Equal(p3, p4))

	p5 := FloatPair{X: 0.1 + 0.2}
	p6 := FloatPair{X: 0.3}
	fmt.Println("p5 equals p6?", cmp.Equal(p5, p6))
}

// EquateApprox 对比浮点数
func Test_FloatPair_看这里(t *testing.T) {
	p1 := FloatPair{X: math.NaN()}
	p2 := FloatPair{X: math.NaN()}
	fmt.Println("p1 equals p2?", cmp.Equal(p1, p2, cmpopts.EquateNaNs()))

	f1 := 0.1
	f2 := 0.2
	f3 := 0.3
	p3 := FloatPair{X: f1 + f2}
	p4 := FloatPair{X: f3}
	fmt.Println("p3 equals p4?", cmp.Equal(p3, p4, cmpopts.EquateApprox(0.1, 0.001)))
}

// 默认情况下，如果一个切片变量值为nil，另一个是使用make创建的长度为 0 的切片，那么go-cmp认为它们是不等的。
// 同样的，一个map变量值为nil，另一个是使用make创建的长度为 0 的map，那么go-cmp也认为它们不等。
// 我们可以指定cmpopts.EquateEmpty选项，让go-cmp认为它们相等：
func Test_nil(t *testing.T) {
	var s1 []int
	var s2 = make([]int, 0)

	var m1 map[int]int
	var m2 = make(map[int]int)

	fmt.Println("s1 equals s2?", cmp.Equal(s1, s2))
	fmt.Println("m1 equals m2?", cmp.Equal(m1, m2))

	fmt.Println("s1 equals s2 with option?", cmp.Equal(s1, s2, cmpopts.EquateEmpty()))
	fmt.Println("m1 equals m2 with option?", cmp.Equal(m1, m2, cmpopts.EquateEmpty()))
}

// 默认情况下，两个切片只有当长度相同，且对应位置上的元素都相等时，go-cmp才认为它们相等。
// 如果，我们想要实现无序切片的比较（即只要两个切片包含相同的值就认为它们相等），可以使用cmpopts.SortedSlice选项先对切片进行排序，然后再进行比较：
func Test_slice(t *testing.T) {
	s1 := []int{1, 2, 3, 4}
	s2 := []int{4, 3, 2, 1}
	fmt.Println("s1 equals s2?", cmp.Equal(s1, s2))
	fmt.Println("s1 equals s2 with option?", cmp.Equal(s1, s2, cmpopts.SortSlices(func(i, j int) bool { return i < j })))
}

// 对于map来说，由于本身就是无序的，所以map比较差不多是下面这种形式。没有上面的顺序问题：
// cmpopts.SortMaps会将map[K]V类型按照键排序，生成一个[]struct{K, V}的切片，然后逐个比较。
func Test_map(t *testing.T) {
	s1 := []int{1, 2, 3, 4}
	s2 := []int{4, 3, 2, 1}
	fmt.Println("s1 equals s2?", cmp.Equal(s1, s2))
	fmt.Println("s1 equals s2 with option?", cmp.Equal(s1, s2, cmpopts.SortSlices(func(i, j int) bool { return i < j })))

	m1 := map[int]int{1: 10, 2: 20, 3: 30}
	m2 := map[int]int{1: 10, 2: 20, 3: 30}
	fmt.Println("m1 equals m2?", cmp.Equal(m1, m2))
	fmt.Println("m1 equals m2 with option?", cmp.Equal(m1, m2, cmpopts.SortMaps(func(i, j int) bool { return i < j })))
}

type NetAddr struct {
	IP   string
	Port int
}

func (a NetAddr) Equal(b NetAddr) bool {
	if a.Port != b.Port {
		return false
	}
	if a.IP != b.IP {
		if a.IP == "127.0.0.1" && b.IP == "localhost" {
			return true
		}
		if a.IP == "localhost" && b.IP == "127.0.0.1" {
			return true
		}
		return false
	}
	return true
}

// 自定义比较器
func Test_diy_equal(t *testing.T) {
	a1 := NetAddr{"127.0.0.1", 5000}
	a2 := NetAddr{"localhost", 5000}
	a3 := NetAddr{"192.168.1.1", 5000}

	fmt.Println("a1 equals a2?", cmp.Equal(a1, a2))
	fmt.Println("a1 equals a3?", cmp.Equal(a1, a3))
}
