package main

import (
	"context"
	"fmt"
	"time"
)

func main() {
	parentCtx := context.Background()
	ctx, cancel := context.WithTimeout(parentCtx, 2*time.Second)
	defer cancel()

	select {
	case <-time.After(1 * time.Second):
		f1(ctx)
	case <-ctx.Done():
		f2(ctx)
	}
}

func f1(ctx context.Context) {
	fmt.Println("脑子进煎鱼了", ctx.Err())
}

func f2(ctx context.Context) {
	fmt.Println("煎鱼进脑子了", ctx.Err())
}
