package channel

import (
	"fmt"
	"testing"
)

type Person struct {
	Name string
	Age  int
}

func SendPerson(ch chan Person, p Person) {
	ch <- p
}

func Test_Channel_obj(t *testing.T) {

	p := Person{"John", 23}

	ch := make(chan Person)

	go SendPerson(ch, p)

	name := (<-ch).Name
	fmt.Println(name)
}
