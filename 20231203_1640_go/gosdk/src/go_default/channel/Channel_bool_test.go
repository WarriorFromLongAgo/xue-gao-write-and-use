package channel

import (
	"fmt"
	"testing"
	"time"
)

func worker(done chan bool) {
	fmt.Print("working...")
	time.Sleep(time.Second * 3)
	fmt.Println("done")

	done <- true
}

func Test_Channel_bool_test(t *testing.T) {

	done := make(chan bool, 1)
	go worker(done)
	<-done
}
