# webocket
国内镜像: https://gitee.com/kotori912/websocket-woll.git
github: https://github.com/xiaoniaodepangci/websocket-woll
## 本项目主要是对 spring-boot-websocket-start包的使用
### 本项目从单机的websocket服务开始,逐步集成数据库,权限认证,分布式集群,用户登录等等

## 项目结构

~~~
com.hc     
├── html                  // 前端模块文件
├── single-server         // 单机模式
├──pom.xml                // 公共依赖
~~~
每个模块下面都有相应的README.md

## 统一使用nacos作为配置中心(configServer)
nacos: https://github.com/alibaba/nacos/releases/tag/1.4.0

食用nacos请务必查看nacos文件夹下的README.md