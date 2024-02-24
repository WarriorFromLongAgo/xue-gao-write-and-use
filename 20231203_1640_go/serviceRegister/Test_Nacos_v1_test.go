package serviceRegister

import (
	"bufio"
	"fmt"
	"github.com/nacos-group/nacos-sdk-go/v2/clients"
	"github.com/nacos-group/nacos-sdk-go/v2/clients/naming_client"
	"github.com/nacos-group/nacos-sdk-go/v2/common/constant"
	"github.com/nacos-group/nacos-sdk-go/v2/vo"
	"net"
	"testing"
	"time"
)

// 定义类型别名
type NacosConfig struct {
	ServiceName string
	Host        string
	Port        uint64
}

func Nacos_RegisterService(config NacosConfig) (err error, iClient naming_client.INamingClient) {
	//create ServerConfig
	serverConfig := []constant.ServerConfig{
		*constant.NewServerConfig(config.Host, config.Port),
	}
	//create ClientConfig
	// 创建 Nacos 客户端配置
	clientConfig := *constant.NewClientConfig(
		constant.WithNamespaceId(""),
		constant.WithTimeoutMs(5000),           // 设置请求超时时间
		constant.WithNotLoadCacheAtStart(true), // 设置启动时不加载缓存
		constant.WithLogDir("nacosLogs"),
		constant.WithCacheDir("nacosCache"),
		constant.WithLogLevel("debug"),
	)

	// create naming client
	namingClient, err := clients.NewNamingClient(
		vo.NacosClientParam{
			ClientConfig:  &clientConfig,
			ServerConfigs: serverConfig,
		},
	)

	if err != nil {
		panic(err)
	}

	// 注册服务实例到 Nacos
	param := vo.RegisterInstanceParam{
		Ip:          config.Host,                      // 你的服务实例的IP地址
		Port:        config.Port,                      // 你的服务实例的端口号
		ServiceName: config.ServiceName,               // 你的服务名称
		Weight:      10,                               // 权重
		ClusterName: "default",                        // 集群名称
		Enable:      true,                             // 是否启用
		Healthy:     true,                             // 是否健康
		Metadata:    map[string]string{"env": "test"}, // 元数据
	}

	success, err := namingClient.RegisterInstance(param)
	if !success || err != nil {
		fmt.Println("RegisterInstance failed:", err)
		return nil, namingClient
	}

	fmt.Println("RegisterInstance succeeded!")
	return nil, namingClient
}

func Nacos_DeRegisterService(config NacosConfig, iClient naming_client.INamingClient) {
	// 取消服务注册
	_, err := iClient.DeregisterInstance(vo.DeregisterInstanceParam{
		Ip:          config.Host,
		Port:        config.Port,
		ServiceName: config.ServiceName,
	})
	if err != nil {
		panic(err)
	}
}

func Test_v1(t *testing.T) {
	ch := make(chan error)

	// 定义并初始化临时对象
	nacosConfig := NacosConfig{
		ServiceName: "tempApplication",
		Host:        "127.0.0.1",
		Port:        8848,
	}
	err, client := Nacos_RegisterService(nacosConfig)
	if err != nil {
		return
	}

	time.Sleep(time.Minute * 1)

	Nacos_DeRegisterService(nacosConfig, client)

	ls, err := net.Listen("tcp", ":10111")
	if err != nil {
		fmt.Printf("start tcp listener error: %v\n", err.Error())
		return
	}
	for {
		conn, err := ls.Accept()
		if err != nil {
			fmt.Printf("connect error: %v\n", err.Error())
		}
		go func(conn net.Conn) {
			_, err := bufio.NewWriter(conn).WriteString("hello consul")
			if err != nil {
				fmt.Printf("write conn error: %v\n", err)
			}
		}(conn)
	}

	// 阻塞等待
	<-ch

}

//作者：PPT之神陶喆
//链接：https://juejin.cn/post/7172818468415209508
//来源：稀土掘金
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
