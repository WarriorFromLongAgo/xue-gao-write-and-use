FROM golang:1.21.4 AS builder

LABEL stage=gobuilder

ENV CGO_ENABLED 0
ENV GOOS linux
ENV GOPROXY https://goproxy.cn,direct

WORKDIR /build

ADD go.mod .
ADD go.sum .
RUN go mod download
COPY . .
RUN go build -ldflags="-s -w" -o /app/main ./main.go


FROM alpine

RUN apk update --no-cache && apk add --no-cache ca-certificates tzdata
ENV TZ Asia/Shanghai

WORKDIR /app
COPY --from=builder /app/main /app/main

CMD ["./main"]

#作者：万俊峰Kevin
#链接：https://juejin.cn/post/7072159698379604004
#来源：稀土掘金
#著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

#默认禁用了 cgo
#启用了 GOPROXY
#去掉了调试信息 -ldflags="-s -w" 以减小镜像尺寸
#安装了 ca-certificates，这样使用 TLS证书就没问题了
#自动设置了本地时区，这样我们在日志里看到的是北京时间了

# docker build -t hello:v3 .
# docker run -it --rm -p 8080:8080 hello:v3



