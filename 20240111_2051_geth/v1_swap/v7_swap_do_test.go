package v1_swap

import (
	"context"
	"crypto/ecdsa"
	"fmt"
	"github.com/ethereum/go-ethereum/common"
	"github.com/ethereum/go-ethereum/core/types"
	"github.com/ethereum/go-ethereum/crypto"
	"github.com/ethereum/go-ethereum/ethclient"
	"log"
	"math/big"
	"testing"
)

func Test_v7(t *testing.T) {
	client, err := ethclient.Dial("http://localhost:7545")
	if err != nil {
		log.Fatal(err)
		return
	}
	fmt.Println("we have a connection")

	//加载私钥
	srcPrivateKey := "0xa60c02d2196fb1de21a905a71ecd2b7f6e2f5a383cb42feabcdf4626fcc7131a"[2:]
	fmt.Println("srcPrivateKey", srcPrivateKey)
	privateKey, err := crypto.HexToECDSA(srcPrivateKey)
	if err != nil {
		log.Fatal(err)
		return
	}
	fmt.Println("privateKey", privateKey)
	publicKey := privateKey.Public()
	publicKeyECDSA, ok := publicKey.(*ecdsa.PublicKey)
	if !ok {
		log.Fatal("cannot assert type: publicKey is not of type *ecdsa.PublicKey")
		return
	}
	fmt.Println("publicKeyECDSA = ", publicKeyECDSA)
	fromAddress := crypto.PubkeyToAddress(*publicKeyECDSA)
	nonce, err := client.PendingNonceAt(context.Background(), fromAddress)
	if err != nil {
		log.Fatal(err)
		return
	}
	// in wei (1 eth)
	value := big.NewInt(1000000000000000000)
	//ETH转账的燃气应设上限为“21000”单位。
	gasLimit := uint64(21000) // in units
	//燃气价格必须以wei为单位设定。 在撰写本文时，将在一个区块中比较快的打包交易的燃气价格为30 gwei。
	//gasPrice := big.NewInt(30000000000) // in wei (30 gwei)
	//燃气价格总是根据市场需求和用户愿意支付的价格而波动的，因此对燃气价格进行硬编码有时并不理想。
	//go-ethereum客户端提供SuggestGasPrice函数，用于根据’x’个先前块来获得平均燃气价格。
	gasPrice, err := client.SuggestGasPrice(context.Background())
	if err != nil {
		log.Fatal(err)
		return
	}

	toAddress := common.HexToAddress("0x4b4524752C5A42d2b46776bE96989fC3Fe91Ec03")
	fmt.Println("toAddress = ", toAddress)

	tx := types.NewTransaction(nonce, toAddress, value, gasLimit, gasPrice, nil)
	fmt.Println("tx = ", tx)

	chainID, err := client.ChainID(context.Background())
	if err != nil {
		log.Fatal(err)
		return
	}
	fmt.Println("chainID = ", chainID)

	signedTx, err := types.SignTx(tx, types.NewEIP155Signer(chainID), privateKey)
	if err != nil {
		log.Fatal(err)
		return
	}
	fmt.Println("signedTx = ", signedTx)
	err = client.SendTransaction(context.Background(), signedTx)
	if err != nil {
		log.Fatal("SendTransaction = ", err)
		return
	}
	fmt.Printf("tx sent: %s", signedTx.Hash().Hex()) // tx sent: 0x77006fcb3938f648e2cc65bafd27dec30b9bfbe9df41f78498b9c8b7322a249e

	fmt.Println("end end end end end")
	fmt.Println("===============================")
}
