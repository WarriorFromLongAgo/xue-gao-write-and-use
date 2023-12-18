package main

import (
	"net/http"
)

func main() {
	http.HandleFunc("/index", func(writer http.ResponseWriter, request *http.Request) {
		write, err := writer.Write([]byte("HandleFunc implement"))
		if err != nil {
			return
		}
		println(write)
	})
	http.ListenAndServe(":8080", nil)

}
