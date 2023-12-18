package main

import "github.com/google/wire"

func newEvent(msg string) Event {
	wire.Build(NewEvent, NewGreeter, NewMessage)
	return Event{}
}

//首先这个函数的返回值就是我们需要创建的对象类型，wire只需要知道类型，return后返回什么不重要。
//然后在函数中，我们调用wire.Build()将创建Mission所依赖的类型的构造器传进去。
//例如，需要调用NewMission()创建Mission类型，NewMission()接受两个参数一个Monster类型，一个Player类型。
//Monster类型对象需要调用NewMonster()创建，Player类型对象需要调用NewPlayer()创建。
//所以NewMonster()和NewPlayer()我们也需要传给wire。
