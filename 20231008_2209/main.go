package main

import "fmt"

func main() {
	const (
		n1 = 100
		n2
		n3
	)
	fmt.Println(n1, n2, n3)
	// 100, 100, 100

	const (
		n10 = iota
		n20 = 100
		n30 = iota
		n40
	)
	fmt.Println(n10, n20, n30, n40)
	// 0 100 2 3

	const (
		n100 = iota
		_
		n300
	)
	fmt.Println(n100, n300)
	// 0, 2

	const (
		n1000, n2000 = iota, iota + 2
		n3000, n4000
		n5000, n6000
	)
	fmt.Println(n1000, n2000, n3000, n4000, n5000, n6000)
	// 0 2 1 3 2 4

}
