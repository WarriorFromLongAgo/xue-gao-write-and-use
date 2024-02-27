package _0240227_natsio_a

import (
	"github.com/nats-io/nats.go"
	"testing"
)

func Test_natsio_request(t *testing.T) {
	url := nats.DefaultURL

	nc, _ := nats.Connect(url)
	defer nc.Drain()

	// Matches all of the above
	nc.Publish("foo.bar.baz", []byte("Hello World")) // Use the response

	println("request request request")
}
