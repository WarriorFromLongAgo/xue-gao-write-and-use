package main

import "fmt"

func main() {

	slice := []int{0, 1, 2, 3}
	m := make(map[int]*int)

	// for key, val := range slice {
	// 	fmt.Println("key=", key)
	// 	fmt.Println("val=", val)
	// 	m[key] = &val
	// }

	for key, val := range slice {
		value := val
		m[key] = &value
	}

	for k, v := range m {
		fmt.Println(k, "->", *v)
	}
}
