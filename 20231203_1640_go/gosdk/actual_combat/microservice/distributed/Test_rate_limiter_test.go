package distributed

import (
	"fmt"
	"testing"
	"time"
)

//此通道将接收一个值 每 200 毫秒。这是调节器 我们的速率限制方案。limiter
//通过阻止来自通道的接收 在处理每个请求之前，我们将自己限制在 每 1 毫秒 200 个请求。limiter
//每隔 200 毫秒，我们将尝试添加一个新的 值为 ，最多限制为 3。burstyLimiter
//现在再模拟 5 个传入请求。第一个 其中 3 个将受益于突发能力 之。burstyLimiter
//运行我们的程序，我们看到第一批请求 根据需要每 ~200 毫秒处理一次。
//对于第二批请求，我们为第一批请求提供服务 3.由于可突发速率限制，立即进行， 然后以 ~2 毫秒的延迟为剩余的 200 个提供服务。

func Test_rate(t *testing.T) {

	requests := make(chan int, 5)
	for i := 1; i <= 5; i++ {
		requests <- i
	}
	close(requests)

	limiter := time.Tick(200 * time.Millisecond)

	for req := range requests {
		<-limiter
		fmt.Println("request", req, time.Now())
	}

	burstyLimiter := make(chan time.Time, 3)

	for i := 0; i < 3; i++ {
		burstyLimiter <- time.Now()
	}

	go func() {
		for t := range time.Tick(200 * time.Millisecond) {
			burstyLimiter <- t
		}
	}()

	burstyRequests := make(chan int, 5)
	for i := 1; i <= 5; i++ {
		burstyRequests <- i
	}
	close(burstyRequests)
	for req := range burstyRequests {
		<-burstyLimiter
		fmt.Println("request", req, time.Now())
	}
}
