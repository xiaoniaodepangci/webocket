## 创建数据库

创建websocket_config数据库

编码utf8mb4 utf8mb4_general_ci

执行websocket_config.sql文件

已测试 mysql5.7.30 mysql8.0.21使用websocket_config.sql没有问题

有问题的同学请更新数据库或者把配置拷贝出来放到bootstrap.yml里(这时候就要移除bootstrap.yml的nacos配置 以及nacos依赖)
## 配置nacos使用数据库
### 在nacos的conf目录修改application.properties

```$text
#*************** Config Module Related Configurations ***************#
### If use MySQL as datasource:
spring.datasource.platform=mysql

### Count of DB:
db.num=1

### Connect URL of DB:
db.url.0=jdbc:mysql://127.0.0.1:3306/websocket_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=root
db.password=123456
```

##nacos1.4.0版本发现问题  

1.4.0版本的默认启动方式为集群,会有异常
```$log
Caused by: java.net.UnknownHostException: jmenv.tbsite.net
        at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:567)
        at java.base/java.net.Socket.connect(Socket.java:648)
        at java.base/sun.net.NetworkClient.doConnect(NetworkClient.java:177)
        at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:474)
        at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:569)
        at java.base/sun.net.www.http.HttpClient.<init>(HttpClient.java:242)
        at java.base/sun.net.www.http.HttpClient.New(HttpClient.java:341)
        at java.base/sun.net.www.http.HttpClient.New(HttpClient.java:362)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.getNewHttpClient(HttpURLConnection.java:1261)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect0(HttpURLConnection.java:1194)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect(HttpURLConnection.java:1082)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.connect(HttpURLConnection.java:1016)
        at com.alibaba.nacos.common.http.client.request.JdkHttpClientRequest.execute(JdkHttpClientRequest.java:109)
        at com.alibaba.nacos.common.http.client.NacosRestTemplate.execute(NacosRestTemplate.java:482)
        at com.alibaba.nacos.common.http.client.NacosRestTemplate.get(NacosRestTemplate.java:72)
        at com.alibaba.nacos.core.cluster.lookup.AddressServerMemberLookup.syncFromAddressUrl(AddressServerMemberLookup.java:145)
        at com.alibaba.nacos.core.cluster.lookup.AddressServerMemberLookup.run(AddressServerMemberLookup.java:113)
        ... 124 common frames omitted
```
##解决办法

修改nacos bin文件夹下的start.cmd 修改以下位置

第27行 
set MODE="cluster" 改为---> set MODE="standalone"

## 或使用脚本启动

脚本启动一般用于linux系统 windows系统请食用cmd脚本
```$xslt
./startup.sh -m standalone 
```

