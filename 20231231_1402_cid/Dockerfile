# syntax=docker/dockerfile:1

FROM golang:1.21.4

ENV GO111MODULE=on \
    CGO_ENABLED=0 \
    GOOS=linux \
    GOARCH=amd64 \
	GOPROXY="https://goproxy.cn,direct"

MAINTAINER "20231231_1402_cid"

WORKDIR /build

COPY main.go .

RUN go build -o main main.go

EXPOSE 8080

CMD ["./main"]


# 构建您的第一个 Docker 映像。
# docker build -t 20231231_1402_cid .
# docker images
# docker run -p 8080:8080 -d chengqiang