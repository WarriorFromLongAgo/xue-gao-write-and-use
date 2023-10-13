package main

import "fmt"

type Animal struct {
	Name string
}

type Dog struct {
	Age    int
	Animal Animal
}

type Cat struct {
	Age    int
	Animal *Animal
}

func main() {
	var dog1 = Dog{
		Age: 11,
		Animal: Animal{
			Name: "dog1 dog1",
		},
	}
	fmt.Println("dog1 ", dog1)
	fmt.Println("==============================================")

	var cat1 = Cat{
		Age: 11,
		Animal: &Animal{
			Name: "cat1 cat1",
		},
	}
	fmt.Println("cat1 ", cat1)
	fmt.Println("==============================================")
}
