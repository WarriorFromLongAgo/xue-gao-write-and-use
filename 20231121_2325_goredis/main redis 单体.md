package main

import (
	"fmt"

	"github.com/gomodule/redigo/redis"
)

// go get github.com/garyburd/redigo/redis

func main() {
	c, err := redis.Dial("tcp", "localhost:6379")

	if err != nil {
		fmt.Println("conn redis failed,", err)
		return
	}

	fmt.Println("redis conn success")
	defer c.Close()

	// setStr(c)
	// getStr(c)

	// msetStr(c)
	// mgetStr(c)

	expire(c)

}

func setStr(c redis.Conn) {
	value, err := c.Do("Set", "abc", 100)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println("setStr", value)
}

func getStr(c redis.Conn) {
	value, err := redis.Int(c.Do("Get", "abc"))
	if err != nil {
		fmt.Println("get abc failed,", err)
		return
	}
	fmt.Println("getStr", value)
}

func msetStr(c redis.Conn) {
	value, err := c.Do("MSet", "aaaa", 1111, "bbbb", 2222)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println("msetStr", value)
}

func mgetStr(c redis.Conn) {
	value, err := redis.Ints(c.Do("MGet", "aaaa", "bbbb"))
	if err != nil {
		fmt.Println("MGet abc failed,", err)
		return
	}
	for _, v := range value {
		fmt.Println("mgetStr", v)
	}
}

func expire(c redis.Conn) {
	_, err := c.Do("expire", "abc", 10)
	if err != nil {
		fmt.Println(err)
		return
	}

}

// list
// _, err = c.Do("lpush", "book_list", "abc", "ceg", 300)
// if err != nil {
// 		fmt.Println(err)
// 		return
// }

// r, err := redis.String(c.Do("lpop", "book_list"))
// if err != nil {
// 		fmt.Println("get abc failed,", err)
// 		return
// }

// fmt.Println(r)

// hash
// _, err = c.Do("HSet", "books", "abc", 100)
// if err != nil {
// 		fmt.Println(err)
// 		return
// }

// r, err := redis.Int(c.Do("HGet", "books", "abc"))
// if err != nil {
// 		fmt.Println("get abc failed,", err)
// 		return
// }
