package _0240227_natsio_a

import (
	"testing"
)

func Test_server_2(t *testing.T) {
	router := pre()

	run(router, 8082)
}
