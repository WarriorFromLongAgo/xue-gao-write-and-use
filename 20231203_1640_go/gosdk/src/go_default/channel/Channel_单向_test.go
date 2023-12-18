package channel

import "testing"

func f(ch chan<- int, v int) {
	ch <- v
}

func Test_Channel_单向(t *testing.T) {
	// send-only channel
	ch := make(chan<- int)

	go f(ch, 42)
	go f(ch, 41)
	go f(ch, 40)

}

//ch := make(chan<- data_type)        // The channel operator is after the chan keyword
// The channel is send-only

//ch := make(<-chan data_type)        // The channel operator is before the chan keyword
// The channel is receive-only
