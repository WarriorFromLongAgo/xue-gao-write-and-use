package _0240227_natsio_a

import (
	"fmt"
	"github.com/nats-io/nats.go"
	"testing"
	"time"
)

func Test_natsio_request(t *testing.T) {
	url := nats.DefaultURL

	nc, _ := nats.Connect(url)
	defer nc.Drain()

	sub, _ := nc.Subscribe("greet.*", func(msg *nats.Msg) {

		name := msg.Subject[6:]
		msg.Respond([]byte("hello, " + name))
	})

	rep, _ := nc.Request("greet.joe", nil, time.Second)
	fmt.Println(string(rep.Data))

	rep, _ = nc.Request("greet.sue", nil, time.Second)
	fmt.Println(string(rep.Data))

	rep, _ = nc.Request("greet.bob", nil, time.Second)
	fmt.Println(string(rep.Data))

	sub.Unsubscribe()

	_, err := nc.Request("greet.joe", nil, time.Second)
	fmt.Println(err)
}
