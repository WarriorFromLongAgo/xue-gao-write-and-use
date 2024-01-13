package main

import (
	"context"
	"fmt"
	"github.com/ethereum/go-ethereum/common"
	"github.com/ethereum/go-ethereum/ethclient"
	"log"
	"regexp"
	"testing"
)

func Test_v4(t *testing.T) {
	//检查地址是否有效
	re := regexp.MustCompile("^0x[0-9a-fA-F]{40}$")
	fmt.Printf("is valid: %v\n", re.MatchString("0x323b5d4c32345ced77393b3530b1eed0f346429d")) // is valid: true
	fmt.Printf("is valid: %v\n", re.MatchString("0xZYXb5d4c32345ced77393b3530b1eed0f346429d")) // is valid: false

	client, err := ethclient.Dial("http://localhost:7545")
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("we have a connection")
	//检查地址是否为账户或智能合约
	// 0x Protocol Token (ZRX) smart contract address
	address := common.HexToAddress("0x5d2eA71115dd64074056e7D834e1610FC1F38D59")
	bytecode, err := client.CodeAt(context.Background(), address, nil) // nil is latest block
	if err != nil {
		log.Fatal(err)
	}
	isContract := len(bytecode) > 0
	fmt.Printf("is contract: %v\n", isContract) // is contract: true

	fmt.Println("end end end end end")
	fmt.Println("===============================")
}
