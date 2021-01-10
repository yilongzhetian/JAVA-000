[TOC]
# docker安装

1. docker pull redis
2. docker run -itd --name redis-test -p 6379:6379 redis
3. docker image inspect redis:latest|grep -i version
4. docker exec -it redis-test /bin/bash

# docker搭建主从

## 配置

### 主配置
bind 0.0.0.0

### 从配置
bind 0.0.0.0  
replicaof 172.17.0.2 6379
## 启动

```
docker run -p 6379:6379 --name redis-master -v /Users/liwenlong/work/study/redis/master-slave/master.conf:/etc/redis/redis.conf -d redis redis-server /etc/redis/redis.conf --appendonly yes
```

```
docker run -p 6380:6379 --name redis-slave -v /Users/liwenlong/work/study/redis/master-slave/slave.conf:/etc/redis/redis.conf -d redis redis-server /etc/redis/redis.conf --appendonly yes
```
## 访问
1.master
```
➜  ~ redis-cli -h 127.0.0.1 -p 6379
127.0.0.1:6379> set test 123
OK
127.0.0.1:6379> get test
"123"
127.0.0.1:6379>
```
2.slave
```
➜  ~ redis-cli -h 127.0.0.1 -p 6380
127.0.0.1:6380> get test
"123"
127.0.0.1:6380> set test 456
(error) READONLY You can't write against a read only replica.
127.0.0.1:6380>
```
# docker搭建sentinel高可用
## 配置
### sentinel-26379.conf
bind 0.0.0.0  
sentinel monitor mymaster 172.17.0.2 6379 2
### sentinel-26380.conf
bind 0.0.0.0  
sentinel monitor mymaster 172.17.0.2 6379 2
### sentinel-26381.conf
bind 0.0.0.0  
sentinel monitor mymaster 172.17.0.2 6379 2
## 启动

```
docker run -p 26379:26379 --name redis-sentinel-26379 -v /Users/liwenlong/work/study/redis/sentinel/sentinel-26379.conf:/etc/redis/sentinel.conf -d redis redis-sentinel /etc/redis/sentinel.conf --appendonly yes
```

```
docker run -p 26380:26379 --name redis-sentinel-26380 -v /Users/liwenlong/work/study/redis/sentinel/sentinel-26380.conf:/etc/redis/sentinel.conf -d redis redis-sentinel /etc/redis/sentinel.conf --appendonly yes
```

```
docker run -p 26381:26379 --name redis-sentinel-26381 -v /Users/liwenlong/work/study/redis/sentinel/sentinel-26381.conf:/etc/redis/sentinel.conf -d redis redis-sentinel /etc/redis/sentinel.conf --appendonly yes
```
## 访问
```
➜  sentinel redis-cli -h 127.0.0.1 -p 26379

# Sentinel
sentinel_masters:1
sentinel_tilt:0
sentinel_running_scripts:0
sentinel_scripts_queue_length:0
sentinel_simulate_failure_flags:0
master0:name=mymaster,status=ok,address=172.17.0.2:6379,slaves=1,sentinels=3
```
## 切换
```
docker stop redis-master

#Sentinel信息
sentinel_masters:1
sentinel_tilt:0
sentinel_running_scripts:0
sentinel_scripts_queue_length:0
sentinel_simulate_failure_flags:0
master0:name=mymaster,status=ok,address=172.17.0.3:6379,slaves=1,sentinels=3
```

```
docker start redis-master
#redis-slave中从库信息
Replication
role:slave
master_host:172.17.0.3
master_port:6379
master_link_status:up
```

