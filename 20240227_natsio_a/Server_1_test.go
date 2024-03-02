package _0240227_natsio_a

import (
	"encoding/json"
	"github.com/nats-io/nats.go"
	"log"
	"testing"
	"time"
)

func Test_server_1(t *testing.T) {
	router := pre()

	var url = "nats://127.0.0.1:4222"
	nc, err := nats.Connect(url, nats.Name("dalongdemo"))
	if err != nil {
		log.Fatal("connect error")
	}
	//这边处理api的结果
	nc.Subscribe("dalong", func(mess *nats.Msg) {
		log.Println(string(mess.Data), "from nats")
		result, _ := json.Marshal(mess)
		log.Println("the reply info is ================", string(result))
		time.Sleep(2 * time.Second)
		nc.Publish(mess.Reply, []byte("dalong can help you"))
	})

	run(router, 8081)
}
