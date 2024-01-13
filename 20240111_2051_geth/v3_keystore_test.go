package main

import (
	"fmt"
	"github.com/ethereum/go-ethereum/accounts/keystore"
	"log"
	"os"
	"testing"
)

func Test_v3_create_keystore(t *testing.T) {
	ks := keystore.NewKeyStore("./tmp", keystore.StandardScryptN, keystore.StandardScryptP)
	password := "secret"
	account, err := ks.NewAccount(password)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(account.Address.Hex()) // 0x20F8D42FB0F667F2E53930fed426f225752453b3

	fmt.Println("end end end end end")
	fmt.Println("===============================")
}

func Test_v3_import_keystore(t *testing.T) {
	file := "./tmp/UTC--2024-01-13T04-03-41.024787100Z--1c32b88cf0bffe5387e0178b0d9b91962d50d559"
	ks := keystore.NewKeyStore("./tmp", keystore.StandardScryptN, keystore.StandardScryptP)
	jsonBytes, err := os.ReadFile(file)
	if err != nil {
		log.Fatal(err)
	}
	password := "secret"
	account, err := ks.Import(jsonBytes, password, password)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(account.Address.Hex()) // 0x20F8D42FB0F667F2E53930fed426f225752453b3
	if err := os.Remove(file); err != nil {
		log.Fatal(err)
	}

	fmt.Println("end end end end end")
	fmt.Println("===============================")
}
