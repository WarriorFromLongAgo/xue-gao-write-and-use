package flag

import (
	"flag"
	"fmt"
	"testing"
)

func Test_flag(t *testing.T) {

	wordPtr := flag.String("word", "foo", "a string")

	numbPtr := flag.Int("numb", 42, "an int")
	forkPtr := flag.Bool("fork", false, "a bool")

	var svar string
	flag.StringVar(&svar, "svar", "bar", "a string var")

	flag.Parse()

	fmt.Println("word:", *wordPtr)
	fmt.Println("numb:", *numbPtr)
	fmt.Println("fork:", *forkPtr)
	fmt.Println("svar:", svar)
	fmt.Println("tail:", flag.Args())
}

//
//$ ./command-line-flags -word=opt -numb=7 -fork -svar=flag
//word: opt
//numb: 7
//fork: true
//svar: flag
//tail: []
