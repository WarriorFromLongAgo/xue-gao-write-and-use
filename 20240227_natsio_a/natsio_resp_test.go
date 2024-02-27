package _0240227_natsio_a

import (
	"fmt"
	"github.com/nats-io/nats.go"
	"testing"
)

func Test_natsio_resp(t *testing.T) {
	url := nats.DefaultURL

	nc, _ := nats.Connect(url)
	defer nc.Drain()

	nc.Subscribe("foo.bar.baz", func(m *nats.Msg) {
		fmt.Printf("Msg received on [%s] : %s\n", m.Subject, string(m.Data))
	})
}
