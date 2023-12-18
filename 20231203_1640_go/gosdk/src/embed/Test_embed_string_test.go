package embed

import (
	_ "embed"
	"fmt"
	"testing"
)

//go:embed version.txt
var versionStr string

func Test_embed_string(t *testing.T) {
	fmt.Printf("version %q\n", versionStr)
}
