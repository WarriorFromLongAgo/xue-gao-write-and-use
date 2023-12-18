package main

import (
	"fmt"
	"net/http"
	"testing"
)

func HelloHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello World")
}

func Test_Server(t *testing.T) {
	http.HandleFunc("/", HelloHandler)
	http.ListenAndServe(":8000", nil)
}
