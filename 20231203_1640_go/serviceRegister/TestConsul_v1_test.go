package serviceRegister

import (
	"bufio"
	"fmt"
	"net"
	"testing"

	consulapi "github.com/hashicorp/consul/api"
)

type DiscoveryConfig struct {
	ID      string
	Name    string
	Tags    []string
	Port    int
	Address string
}

var consulAddress = "127.0.0.1:8500"

func RegisterService(dis DiscoveryConfig) error {
	config := consulapi.DefaultConfig()
	config.Address = consulAddress
	client, err := consulapi.NewClient(config)
	if err != nil {
		fmt.Printf("create consul client : %v\n", err.Error())
	}
	registration := &consulapi.AgentServiceRegistration{
		ID:      dis.ID,
		Name:    dis.Name,
		Port:    dis.Port,
		Tags:    dis.Tags,
		Address: dis.Address,
	}
	// 启动tcp的健康检测，注意address不能使用127.0.0.1或者localhost，因为consul-agent在docker容器里，如果用这个的话，
	// consul会访问容器里的port就会出错，一直检查不到实例
	check := &consulapi.AgentServiceCheck{}
	check.TCP = fmt.Sprintf("%s:%d", registration.Address, registration.Port)
	check.Timeout = "5s"
	check.Interval = "5s"
	check.DeregisterCriticalServiceAfter = "60s"
	registration.Check = check

	if err := client.Agent().ServiceRegister(registration); err != nil {
		fmt.Printf("register to consul error: %v\n", err.Error())
		return err
	}
	return nil
}

func startTcp() {
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
}
func Test_v1(t *testing.T) {
	ch := make(chan error)
	dis := DiscoveryConfig{
		ID:      "9527",
		Name:    "main_service",
		Tags:    []string{"a", "b"},
		Port:    10111,
		Address: "127.0.0.1", //通过ifconfig查看本机的eth0的ipv4地址
	}
	go startTcp()
	RegisterService(dis)
	// 阻塞等待
	<-ch
}

//作者：PPT之神陶喆
//链接：https://juejin.cn/post/7172818468415209508
//来源：稀土掘金
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
