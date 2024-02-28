package _0240227_natsio_a

import (
	"github.com/nats-io/nats.go"
	"log"
	"testing"
)

func Test_natsio_request(t *testing.T) {
	url := nats.DefaultURL

	nc, err := nats.Connect(url)
	if err != nil {
		log.Fatal(err)
		return
	}
	defer nc.Drain()

	// Matches all of the above
	nc.Publish("foo", []byte("Hello World")) // Use the response

	println("====================  request request request")
}
