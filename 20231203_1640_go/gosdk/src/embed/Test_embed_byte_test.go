package embed

import (
	_ "embed"
	"fmt"
	"testing"
)

//go:embed version.txt
var versionByte string

func Test_embed(t *testing.T) {
	fmt.Printf("version %q\n", string(versionByte))
}
