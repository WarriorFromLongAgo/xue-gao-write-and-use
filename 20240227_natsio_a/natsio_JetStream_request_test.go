package _0240227_natsio_a

import (
	"context"
	"fmt"
	"github.com/nats-io/nats.go"
	"testing"
	"time"
)

func Test_natsio_JetStream_request_test(t *testing.T) {
	url := nats.DefaultURL
	nc, _ := nats.Connect(url)

	js, _ := nc.JetStream()

	// Create a stream
	js.AddStream(&nats.StreamConfig{
		Name:     "FOO",
		Subjects: []string{"foo"},
		MaxBytes: 1024,
	})

	// Update a stream
	js.UpdateStream(&nats.StreamConfig{
		Name:     "FOO",
		MaxBytes: 2048,
	})

	// Create a durable consumer
	js.AddConsumer("FOO", &nats.ConsumerConfig{
		Durable: "BAR",
	})

	// Get information about all streams (with Context JSOpt)
	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Second)
	defer cancel()
	for info := range js.StreamsInfo(nats.Context(ctx)) {
		fmt.Println("stream name:", info.Config.Name)
	}

	// Get information about all consumers (with MaxWait JSOpt)
	for info := range js.ConsumersInfo("FOO", nats.MaxWait(10*time.Second)) {
		fmt.Println("consumer name:", info.Name)
	}

	// Delete a consumer
	js.DeleteConsumer("FOO", "BAR")

	// Delete a stream
	js.DeleteStream("FOO")

	println("====================  request request request")
}
