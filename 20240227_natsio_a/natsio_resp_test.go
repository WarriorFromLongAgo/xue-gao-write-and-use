package _0240227_natsio_a

import (
	"fmt"
	"github.com/nats-io/nats.go"
	"log"
	"testing"
)

func Test_natsio_resp(t *testing.T) {
	url := nats.DefaultURL

	nc, err := nats.Connect(url)
	if err != nil {
		log.Fatal(err)
		return
	}
	defer nc.Drain()

	nc.Subscribe("foo", func(m *nats.Msg) {
		fmt.Printf("Msg received on [%s] : %s\n", m.Subject, string(m.Data))
	})
	println("====================  resp ")
}
