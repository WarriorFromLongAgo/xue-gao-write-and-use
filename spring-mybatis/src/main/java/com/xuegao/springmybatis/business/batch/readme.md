1，mysql配置
查看当前环境max_allowed_packet的大小,如下 这个版本默认是4M的大小
show global variables like 'max_allowed_packet';
设置为10M
set global max_allowed_packet = 1024*1024*10;

2，驱动配置
allowMultiQueries=true

问题，batch两种方式，sqlsession和拼接sql，两种方式sqlsession会出现sql长度溢出的问题吗