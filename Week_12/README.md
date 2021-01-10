[TOC]
# docker安装

1. docker pull redis
2. docker run -itd --name redis-test -p 6379:6379 redis
3. docker image inspect redis:latest|grep -i version
4. docker exec -it redis-test /bin/bash
# docker搭建主从
## 主配置
bind 0.0.0.0

## 从配置
bind 0.0.0.0
replicaof 172.17.0.2 6379
## 启动

docker run -p 6379:6379 --name redis-master -v /Users/liwenlong/work/study/redis/master-slave/master.conf:/etc/redis/redis.conf -d redis redis-server /etc/redis/redis.conf --appendonly yes

docker run -p 6380:6379 --name redis-slave -v /Users/liwenlong/work/study/redis/master-slave/slave.conf:/etc/redis/redis.conf -d redis redis-server /etc/redis/redis.conf --appendonly yes
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