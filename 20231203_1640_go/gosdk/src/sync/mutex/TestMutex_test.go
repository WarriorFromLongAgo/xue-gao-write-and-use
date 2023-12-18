package mutex

import (
	"fmt"
	"sync"
	"testing"
)

//互斥锁
//在前面的示例中，我们了解了如何管理简单的 使用原子操作的计数器状态。 对于更复杂的状态，我们可以使用互斥锁来安全地访问多个 goroutine 中的数据。

type Container struct {
	mu       sync.Mutex
	counters map[string]int
}

func (c *Container) inc(name string) {

	c.mu.Lock()
	defer c.mu.Unlock()
	c.counters[name]++
}

func Test_Mutex(t *testing.T) {
	c := Container{

		counters: map[string]int{"a": 0, "b": 0},
	}

	var wg sync.WaitGroup

	doIncrement := func(name string, n int) {
		for i := 0; i < n; i++ {
			c.inc(name)
		}
		wg.Done()
	}

	wg.Add(3)
	go doIncrement("a", 10000)
	go doIncrement("a", 10000)
	go doIncrement("b", 10000)

	wg.Wait()
	fmt.Println(c.counters)
}
