package main

import (
	"fmt"
	"math/rand"
	"sync/atomic"
	"testing"
	"time"
)

//在前面的示例中，我们使用带有互斥锁的显式锁定来同步对共享状态的访问 跨多个 goroutines。
//另一种选择是使用 goroutines 和 渠道来达到相同的结果。这种基于渠道的 方法与 Go 的共享内存理念一致 沟通并拥有每条数据 正好是 1 个 goroutine。
//在此示例中，我们的状态将由单个 goroutine。这将保证数据永远不会 并发访问已损坏。为了阅读或 写入该状态，
//其他 goroutines 将发送消息 到所属的goroutine并接收相应的 答复。这些和 s 封装这些请求和拥有的方式 goroutine 来响应。readOpwriteOpstruct

func Test_goroutine_stateful(t *testing.T) {
	var readOps uint64
	var writeOps uint64

	reads := make(chan readOp)
	writes := make(chan writeOp)

	go func() {
		var state = make(map[int]int)
		for {
			select {
			case read := <-reads:
				read.resp <- state[read.key]
			case write := <-writes:
				state[write.key] = write.val
				write.resp <- true
			}
		}
	}()

	for r := 0; r < 100; r++ {
		go func() {
			for {
				read := readOp{
					key:  rand.Intn(5),
					resp: make(chan int)}
				reads <- read
				<-read.resp
				atomic.AddUint64(&readOps, 1)
				time.Sleep(time.Millisecond)
			}
		}()
	}

	for w := 0; w < 10; w++ {
		go func() {
			for {
				write := writeOp{
					key:  rand.Intn(5),
					val:  rand.Intn(100),
					resp: make(chan bool)}
				writes <- write
				<-write.resp
				atomic.AddUint64(&writeOps, 1)
				time.Sleep(time.Millisecond)
			}
		}()
	}

	time.Sleep(time.Second)

	readOpsFinal := atomic.LoadUint64(&readOps)
	fmt.Println("readOps:", readOpsFinal)
	writeOpsFinal := atomic.LoadUint64(&writeOps)
	fmt.Println("writeOps:", writeOpsFinal)
}

type readOp struct {
	key  int
	resp chan int
}
type writeOp struct {
	key  int
	val  int
	resp chan bool
}
