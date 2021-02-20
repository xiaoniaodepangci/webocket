# webocket
码云镜像: https://gitee.com/kotori912/websocket-woll.git

github: https://github.com/xiaoniaodepangci/websocket-woll
## 本项目主要是对 spring-boot-websocket-start包的使用
### 本项目从单机的websocket服务开始,逐步集成数据库,权限认证,分布式集群,用户登录等等

## 项目结构

~~~
com.hc     
├── html                  // 前端模块文件
├── cluster-server-oauth2 // 集群模式-使用oauth2解决授权问题 (还没写)
├── cluster-server-security // 集群模式-使用session共享 （还没写）
├── single-server         // 单机的没有权限只是一个demo （完成了）
├── single-server-shiro   // 单机shiro权限 (进行中)
├── single-server-security  // 单机的spring-security（还没写）
├── common                // 公共模块（目前只有mp的代码生成器）
├──pom.xml                // 
├──
~~~
每个模块下面都有相应的README.md, 没有README的就是这个模块还没写

