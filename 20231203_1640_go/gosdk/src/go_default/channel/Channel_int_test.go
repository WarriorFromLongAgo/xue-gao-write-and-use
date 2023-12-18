package channel

import (
	"fmt"
	"testing"
)

func Test_Channel_int(t *testing.T) {
	var v int
	ch := make(chan int) // create a channel

	go SendDataToChannel(ch, 2) // send data via a goroutine

	v = <-ch // receive data from the channel

	fmt.Println(v) // 2

	for v := range ch {
		fmt.Println(v)
	}
}

func SendDataToChannel(ch chan int, value int) {
	ch <- value
	ch <- value * 2
	ch <- value * 3
	ch <- value * 7
	close(ch)
}
