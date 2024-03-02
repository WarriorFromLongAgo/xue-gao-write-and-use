package _0240227_natsio_a

import (
	"encoding/json"
	"github.com/nats-io/nats.go"
	"log"
	"testing"
	"time"
)

func Test_client(t *testing.T) {
	router := pre()

	var url = "nats://127.0.0.1:4222"
	nc, err := nats.Connect(url, nats.Name("dalongdemo"))
	if err != nil {
		log.Fatal("connect error")
	}
	//通过一个api调用过去
	nc.Subscribe("dalong", func(mess *nats.Msg) {
		log.Println(string(mess.Data), "from nats")
		result, _ := json.Marshal(mess)
		log.Println("the reply info is ================ ", string(result))
	})
	//这里收到api的返回参数
	message, err := nc.Request("dalong", []byte("dalong"), 1*time.Second)
	if err != nil {
		log.Println("get error, timeout", err)
	}
	log.Println("get data====================", string(message.Data))

	run(router, 8080)
}
