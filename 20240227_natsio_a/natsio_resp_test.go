package _0240227_natsio_a

import (
	"fmt"
	"github.com/nats-io/nats.go"
	"log"
	"sync"
	"testing"
	"time"
)

func Test_natsio_resp(t *testing.T) {
	url := nats.DefaultURL

	nc, err := nats.Connect(url)
	if err != nil {
		log.Fatal(err)
		return
	}
	defer nc.Drain()

	var wg sync.WaitGroup
	wg.Add(1)
	_, err2 := nc.Subscribe("foo", func(m *nats.Msg) {
		defer wg.Done()
		fmt.Printf(time.Now().String(), "Msg received on [%s] : %s\n", m.Subject, string(m.Data))
	})
	if err2 != nil {
		log.Fatal(err2)
		return
	}
	wg.Wait()
	println("====================  resp ")
}
