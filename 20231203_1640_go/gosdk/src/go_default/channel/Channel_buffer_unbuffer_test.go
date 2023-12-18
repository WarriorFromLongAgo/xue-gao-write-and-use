package channel

import (
	"fmt"
	"testing"
)

func Test_Channel_unbuffer(t *testing.T) {
	done := make(chan bool)
	go func() {
		fmt.Println(" unbuffer unbuffer unbuffer")
		<-done
	}()
	done <- true
}

func Test_Channel_buffer(t *testing.T) {
	done := make(chan bool, 1)
	go func() {
		fmt.Println(" buffer buffer buffer")
		<-done
	}()
	done <- true
}
