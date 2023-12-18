package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"net/url"
	"strings"
	"time"
)

func main() {

}

func sendGet_Transport() {
	tr := &http.Transport{
		MaxIdleConns:       10,
		IdleConnTimeout:    30 * time.Second,
		DisableCompression: true,
	}
	client := &http.Client{Transport: tr}
	resp, _ := client.Get("https://golang.org")
	defer resp.Body.Close()
}

func sendGet__addHeader() {
	client := &http.Client{
		Timeout: 5 * time.Second,
	}
	req, _ := http.NewRequest("GET", "https://golang.org", nil)
	req.Header.Add("User-Id", "userid123456")
	resp, _ := client.Do(req)
	defer resp.Body.Close()
}

func sendPut() {
	client := &http.Client{
		Timeout: 5 * time.Second,
	}
	req, _ := http.NewRequest("PUT", "https://golang.org", nil)
	resp, _ := client.Do(req)
	defer resp.Body.Close()
}

func sendGet_TimeOut() {
	client := &http.Client{
		Timeout: 5 * time.Second,
	}
	resp, _ := client.Get("https://golang.org")
	defer resp.Body.Close()
}

func sendPostForm() {
	resp, _ := http.PostForm("https://golang.org", url.Values{"username": {"rayjun"}, "password": {"password"}})
	defer resp.Body.Close()
}

func sendPostFormV2() {
	urlValues := url.Values{}
	urlValues.Add("name", "zhaofan")
	urlValues.Add("age", "22")
	resp, _ := http.PostForm("http://httpbin.org/post", urlValues)
	body, _ := io.ReadAll(resp.Body)
	fmt.Println(string(body))
}

func sendPostJson() {
	data := make(map[string]string)
	data["name"] = "zhaofan"
	data["age"] = "23"
	dataJson, _ := json.Marshal(data)
	reader := bytes.NewBuffer(dataJson)

	resp, _ := http.Post("https://golang.org", "application/json;charset=utf-8", reader)
	defer resp.Body.Close()
}

func sendPostJsonV2() {
	urlValues := url.Values{
		"name": {"zhaofan"},
		"age":  {"23"},
	}
	reqBody := urlValues.Encode()
	resp, _ := http.Post("http://httpbin.org/post", "text/html", strings.NewReader(reqBody))
	body, _ := io.ReadAll(resp.Body)
	fmt.Println(string(body))
}

type result struct {
	Args    string            `json:"args"`
	Headers map[string]string `json:"headers"`
	Origin  string            `json:"origin"`
	Url     string            `json:"url"`
}

func sendPostJson_returnJson() {
	resp, err := http.Get("http://httpbin.org/get")
	if err != nil {
		return
	}
	defer resp.Body.Close()
	body, _ := io.ReadAll(resp.Body)
	fmt.Println(string(body))
	var res result
	_ = json.Unmarshal(body, &res)
	fmt.Printf("%#v", res)
}

func sendGet() {
	resp, _ := http.Get("https://golang.org")
	defer func(Body io.ReadCloser) {
		err := Body.Close()
		if err != nil {
			println("err", err.Error())
		}
	}(resp.Body)
	println("1111", resp.Body)
}

func sendGetV2() {
	resp, err := http.Get("http://httpbin.org/get")
	if err != nil {
		fmt.Println(err)
		return
	}
	defer resp.Body.Close()
	body, err := io.ReadAll(resp.Body)
	fmt.Println(string(body))
	fmt.Println(resp.StatusCode)
	if resp.StatusCode == 200 {
		fmt.Println("ok")
	}
}

func sendGet_add_param() {
	params := url.Values{}
	Url, err := url.Parse("http://httpbin.org/get")
	if err != nil {
		return
	}
	params.Set("name", "zhaofan")
	params.Set("age", "23")
	//如果参数中有中文参数,这个方法会进行URLEncode
	Url.RawQuery = params.Encode()
	urlPath := Url.String()
	fmt.Println(urlPath) // https://httpbin.org/get?age=23&name=zhaofan
	resp, err := http.Get(urlPath)
	defer resp.Body.Close()
	body, _ := io.ReadAll(resp.Body)
	fmt.Println(string(body))
}
