package main

import (
	"crypto/ecdsa"
	"fmt"
	"github.com/ethereum/go-ethereum/common/hexutil"
	"github.com/ethereum/go-ethereum/crypto"
	"golang.org/x/crypto/sha3"
	"log"
	"testing"
)

func Test_v2(t *testing.T) {
	privateKey, err := crypto.GenerateKey()
	if err != nil {
		log.Fatal(err)
	}
	privateKeyBytes := crypto.FromECDSA(privateKey)
	fmt.Println("privateKeyBytes = ", privateKeyBytes)
	fmt.Println("hexutil.Encode(privateKeyBytes) = ", hexutil.Encode(privateKeyBytes))
	fmt.Println("hexutil.Encode(privateKeyBytes)[2:] = ", hexutil.Encode(privateKeyBytes)[2:])
	//这就是用于签署交易的私钥，将被视为密码，永远不应该被共享给别人，因为谁拥有它可以访问你的所有资产。
	//由于公钥是从私钥派生的，因此go-ethereum的加密私钥具有一个返回公钥的Public方法。
	publicKey := privateKey.Public()
	fmt.Println("publicKey = ", publicKey)

	//将其转换为十六进制的过程与我们使用转化私钥的过程类似。 我们剥离了0x和前2个字符04，它始终是EC前缀，不是必需的。
	publicKeyECDSA, ok := publicKey.(*ecdsa.PublicKey)
	fmt.Println("publicKeyECDSA = ", publicKeyECDSA)
	if !ok {
		log.Fatal("cannot assert type: publicKey is not of type *ecdsa.PublicKey")
	}
	publicKeyBytes := crypto.FromECDSAPub(publicKeyECDSA)
	fmt.Println("publicKeyBytes = ", publicKeyBytes)
	fmt.Println("hexutil.Encode(publicKeyBytes) = ", hexutil.Encode(publicKeyBytes))
	fmt.Println("hexutil.Encode(publicKeyBytes)[4:] = ", hexutil.Encode(publicKeyBytes)[4:])
	// 9a7df67f79246283fdc93af76d4f8cdd62c4886e8cd870944e817dd0b97934fdd7719d0810951e03418205868a5c1b40b192451367f28e0088dd75e15de40c05

	//现在我们拥有公钥，就可以轻松生成你经常看到的公共地址。 为了做到这一点，go-ethereum加密包有一个PubkeyToAddress方法，它接受一个ECDSA公钥，并返回公共地址。
	address := crypto.PubkeyToAddress(*publicKeyECDSA).Hex()
	fmt.Println(address) // 0x96216849c49358B10257cb55b28eA603c874b05E

	//公共地址其实就是公钥的Keccak-256哈希，然后我们取最后40个字符（20个字节）并用“0x”作为前缀。 以下是使用 golang.org/x/crypto/sha3 的 Keccak256函数手动完成的方法。
	hash := sha3.NewLegacyKeccak256()
	hash.Write(publicKeyBytes[1:])
	fmt.Println(hexutil.Encode(hash.Sum(nil)[12:])) // 0x96216849c49358b10257cb55b28ea603c874b05e

	fmt.Println("end end end end end")
	fmt.Println("===============================")
}
