package main

import (
	"net/http"
	"net/http/httputil"
)

// 反向代理
func main() {
	http.HandleFunc("/formawd", func(writer http.ResponseWriter, request *http.Request) {
		director := func(req *http.Request) {
			req.URL.Scheme = "https"
			req.URL.Host = "golang.org"
			req.URL.Path = "upload"
		}

		proxy := &httputil.ReverseProxy{Director: director}
		proxy.ServeHTTP(writer, request)
	})

	http.ListenAndServe(":8080", nil)

}
