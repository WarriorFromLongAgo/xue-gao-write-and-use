
封装
1，配置结构体

2，全局变量 viper
go get -u github.com/spf13/viper
go get github.com/mitchellh/mapstructure

3，日志封装 zap
平时代码调试，线上 Bug 分析都离不开它。这里将使用 zap 作为日志库，一般来说，日志都是需要写入到文件保存的，
这也是 zap 唯一缺少的部分，所以我将结合 lumberjack 来使用，实现日志切割归档的功能
go get -u go.uber.org/zap
go get -u gopkg.in/natefinch/lumberjack.v2


4，grom
go get -u gorm.io/gorm
GORM 官方支持 sqlite、mysql、postgres、sqlserver
go get -u gorm.io/driver/mysql 

5，路由进行分组调整
把定义路由的文件集中到同一个目录下，并处理前端项目打包后的静态文件。
内置的 http.Server 提供了 Shutdown() 方法，支持平滑重启服务器，本次将使用它调整项目启动代码，若 Go 版本低于 1.8 可以使用 fvbock/endless 来替代

6, 

7, redis
go get github.com/redis/go-redis/v9







 


