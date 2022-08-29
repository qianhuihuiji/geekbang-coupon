# `docker` 安装 `nacos` 集群

拉取镜像，默认拉取最新版本：

```shell
docker pull nacos/nacos-server
```

`nacos1`:

```shell
docker run -d -e PREFER_HOST_MODE=hostname -e MODE=cluster -e NACOS_APPLICATION_PORT=8848 -e NACOS_SERVERS="192.168.88.78:8848 192.168.88.78:8948" -e SPRING_DATASOURCE_PLATFORM=mysql -e MYSQL_SERVICE_HOST=192.168.88.78 -e MYSQL_SERVICE_PORT=33060 -e MYSQL_SERVICE_USER=root -e MYSQL_SERVICE_PASSWORD=root -e MYSQL_SERVICE_DB_NAME=nacos -e NACOS_SERVER_IP=192.168.88.78 -p 8848:8848 --name my-nacos1 nacos/nacos-server
```

`nacos2`:

```shell
docker run -d -e PREFER_HOST_MODE=hostname -e MODE=cluster -e NACOS_APPLICATION_PORT=8948 -e NACOS_SERVERS="192.168.88.78:8848 192.168.88.78:8948" -e SPRING_DATASOURCE_PLATFORM=mysql -e MYSQL_SERVICE_HOST=192.168.88.78 -e MYSQL_SERVICE_PORT=33060 -e MYSQL_SERVICE_USER=root -e MYSQL_SERVICE_PASSWORD=root -e MYSQL_SERVICE_DB_NAME=nacos -e NACOS_SERVER_IP=192.168.88.78 -p 8948:8948 --name my-nacos2 nacos/nacos-server
```

注意点：

- `192.168.88.78` 为本机ip，通过`ifconfig`获取，启动`nacos`后访问地址为`localhost:8848/nacos`

```shell
ifconfig | grep 192
```

- 有个不爽的点，每次切换网络之后，需要重新换启动命令

以上方式会出现以下报错：

```
ErrCode:503,ErrMsg:server is DOWNnow,detailed error message:Optional[Distro protocol is not initialized]
```

**正确姿势**：

```shell
# 创建一个自定义网络
docker network ls
docker network create --driver bridge --subnet=172.19.0.0/16 --gateway=172.19.0.1 mynetwork
docker network inspect mynetwork

#创建Nacos容器
docker run -d -e PREFER_HOST_MODE=hostname -e MODE=cluster -e NACOS_APPLICATION_PORT=8848 -e NACOS_SERVERS="172.19.0.2:8848 172.19.0.3:8948" -e SPRING_DATASOURCE_PLATFORM=mysql -e MYSQL_SERVICE_HOST=192.168.88.78 -e MYSQL_SERVICE_PORT=33060 -e MYSQL_SERVICE_USER=root -e MYSQL_SERVICE_PASSWORD=root -e MYSQL_SERVICE_DB_NAME=nacos -e NACOS_SERVER_IP=172.19.0.2 -p 8848:8848 --net=mynetwork --ip 172.19.0.2 --name my-nacos1 nacos/nacos-server
 
docker run -d -e PREFER_HOST_MODE=hostname -e MODE=cluster -e NACOS_APPLICATION_PORT=8948 -e NACOS_SERVERS="172.19.0.2:8848 172.19.0.3:8948" -e SPRING_DATASOURCE_PLATFORM=mysql -e MYSQL_SERVICE_HOST=192.168.88.78 -e MYSQL_SERVICE_PORT=33060 -e MYSQL_SERVICE_USER=root -e MYSQL_SERVICE_PASSWORD=root -e MYSQL_SERVICE_DB_NAME=nacos -e NACOS_SERVER_IP=172.19.0.3 -p 8948:8948 --net=mynetwork --ip 172.19.0.3 --name my-nacos2 nacos/nacos-server
```
