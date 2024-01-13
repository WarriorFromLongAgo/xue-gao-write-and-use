package main

import (
	"context"
	"fmt"
	"github.com/ethereum/go-ethereum/common"
	"github.com/ethereum/go-ethereum/ethclient"
	"log"
	"math"
	"math/big"
	"testing"
)

func Test_v1(t *testing.T) {
	client, err := ethclient.Dial("http://localhost:7545")
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("we have a connection")
	_ = client // we'll use this in the upcoming sections

	address := common.HexToAddress("0x5d2eA71115dd64074056e7D834e1610FC1F38D59")
	fmt.Println(address.Hex()) // 0x71C7656EC7ab88b098defB751B7401B5f6d8976F
	//fmt.Println(address.Hash().Hex()) // 0x00000000000000000000000071c7656ec7ab88b098defb751b7401b5f6d8976f
	//fmt.Println(address.Bytes())      // [113 199 101 110 199 171 136 176 152 222 251 117 27 116 1 181 246 216 151 111]

	balance, err := client.BalanceAt(context.Background(), address, nil)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(balance)

	fbalance := new(big.Float)
	fbalance.SetString(balance.String())
	ethValue := new(big.Float).Quo(fbalance, big.NewFloat(math.Pow10(18)))
	fmt.Println(ethValue)
	fmt.Println("===============================")

	pendingBalance, err := client.PendingBalanceAt(context.Background(), address)
	fmt.Println(pendingBalance) // 25729324269165216042

	fmt.Println("end end end end end")
	fmt.Println("===============================")
}
