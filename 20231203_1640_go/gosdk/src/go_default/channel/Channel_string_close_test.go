package channel

import (
	"fmt"
	"testing"
)

func SendStringToChannel(ch chan string, s string) {
	ch <- s
	close(ch)
}

func Test_Channel_string_close(t *testing.T) {

	ch := make(chan string)

	go SendStringToChannel(ch, "Hello World!")

	// receive the second value as ok
	// that determines if the channel is closed or not
	v, ok := <-ch

	// check if closed
	if !ok {
		fmt.Println("Channel closed")
	}

	fmt.Println(v) // Hello World!
}
