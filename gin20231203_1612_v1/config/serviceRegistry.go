package config

type ServiceRegistryConfig struct {
	serviceName string
	Host        string
	Port        int
	// nacos | eureka | consul
	RegistryType string
	NacosConfig  NacosConfig
	ConsulConfig ConsulConfig
	EurekaConfig EurekaConfig
}

type NacosConfig struct {
	serviceName string
	Host        string
	Port        int
}

type ConsulConfig struct {
	serviceName string
	Host        string
	Port        int
}

type EurekaConfig struct {
	serviceName string
	Host        string
	Port        int
}
