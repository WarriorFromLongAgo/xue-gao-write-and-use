package _0240227_natsio_a

import (
	"fmt"
	"github.com/nats-io/nats.go"
	"log"
	"sync"
	"testing"
	"time"
)

func Test_natsio_example2(t *testing.T) {
	//example2()
	//example3()
	example4()

}

func example2() {
	url := nats.DefaultURL

	nc, _ := nats.Connect(url)
	defer nc.Drain()

	// Subscribe
	sub, err := nc.SubscribeSync("updates")
	if err != nil {
		log.Fatal(err)
	}
	// Wait for a message
	msg, err := sub.NextMsg(10 * time.Second)
	if err != nil {
		log.Fatal(err)
	}
	// Use the response
	log.Printf("Reply: %s", msg.Data)
}

func example3() {
	url := nats.DefaultURL

	nc, _ := nats.Connect(url)
	defer nc.Drain()

	// Use a WaitGroup to wait for a message to arrive
	wg := sync.WaitGroup{}
	wg.Add(1)

	// Subscribe
	if _, err := nc.Subscribe("updates", func(m *nats.Msg) {
		wg.Done()
	}); err != nil {
		log.Fatal(err)
	}

	// Wait for a message to come in
	wg.Wait()
}

func example4() {
	url := nats.DefaultURL

	nc, _ := nats.Connect(url)
	defer nc.Drain()

	// Subscribe
	sub, err := nc.SubscribeSync("time")
	if err != nil {
		log.Fatal(err)
	}

	// Read a message
	msg, err := sub.NextMsg(10 * time.Second)
	if err != nil {
		log.Fatal(err)
	}

	// Get the time
	timeAsBytes := []byte(time.Now().String())

	// Send the time as the response.
	msg.Respond(timeAsBytes)

	println("44444444444444")
}

func TestNats_example4(t *testing.T) {
	url := nats.DefaultURL

	nc, _ := nats.Connect(url)
	defer nc.Drain()

	var wg sync.WaitGroup
	wg.Add(1)
	nc.Subscribe("foo", func(m *nats.Msg) {
		defer wg.Done()
		fmt.Printf("Msg received on [%s] : %s\n", m.Subject, string(m.Data))
	})

	nc.Publish("foo", []byte("Hello World"))

	wg.Wait()
}
