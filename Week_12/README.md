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

# docker搭建集群分片

## docker网络创建

1. 由于mac不支持docker的host网络模式，因此需要创建docker的自定义网络  
docker network create --driver bridge --subnet=172.18.12.0/16 --gateway=172.18.1.1 mynet  
2. 查看创建好的网络  
docker network inspect mynet  

## 配置

1. 配置文件分别为redis-7001.conf/redis-7002.conf/redis-7003.conf/redis-7004.conf/redis-7005.conf/redis-7006.conf  
2. 对应集群生成的节点文件nodes-7001.conf/nodes-7002.conf/nodes-7003.conf/nodes-7004.conf/nodes-7005.conf/nodes-7006.conf 
3. redis-7001.conf的配置文件如下(其余配置文件类似)  
bind 0.0.0.0  
daemonize no(docker中该配置应使用默认值，否则无法启动)  
cluster-enabled yes  
cluster-config-file nodes-7001.conf  
cluster-node-timeout 15000  

## 启动

```
docker run --network=mynet --ip 172.18.12.1 -p 7001:7001 --name cluster-7001 -v /Users/liwenlong/work/study/redis/cluster/redis-7001.conf:/etc/redis/redis.conf  -d redis redis-server /etc/redis/redis.conf --appendonly yes

docker run --network=mynet --ip 172.18.12.2 -p 7002:7002 --name cluster-7002 -v /Users/liwenlong/work/study/redis/cluster/redis-7002.conf:/etc/redis/redis.conf  -d redis redis-server /etc/redis/redis.conf --appendonly yes

docker run --network=mynet --ip 172.18.12.3 -p 7003:7003 --name cluster-7003 -v /Users/liwenlong/work/study/redis/cluster/redis-7003.conf:/etc/redis/redis.conf  -d redis redis-server /etc/redis/redis.conf --appendonly yes

docker run --network=mynet --ip 172.18.12.4 -p 7004:7004 --name cluster-7004 -v /Users/liwenlong/work/study/redis/cluster/redis-7004.conf:/etc/redis/redis.conf  -d redis redis-server /etc/redis/redis.conf --appendonly yes

docker run --network=mynet --ip 172.18.12.5 -p 7005:7005 --name cluster-7005 -v /Users/liwenlong/work/study/redis/cluster/redis-7005.conf:/etc/redis/redis.conf  -d redis redis-server /etc/redis/redis.conf --appendonly yes

docker run --network=mynet --ip 172.18.12.6 -p 7006:7006 --name cluster-7006 -v /Users/liwenlong/work/study/redis/cluster/redis-7006.conf:/etc/redis/redis.conf  -d redis redis-server /etc/redis/redis.conf --appendonly yes

```

## 集群创建

```
➜  cluster docker exec -it cluster-7001 /bin/bash
root@545fbd0f8876:/data# redis-cli --cluster create 172.18.12.1:7001 172.18.12.2:7002 \
> 172.18.12.3:7003 172.18.12.4:7004 172.18.12.5:7005 172.18.12.6:7006 \
> --cluster-replicas 1
>>> Performing hash slots allocation on 6 nodes...
Master[0] -> Slots 0 - 5460
Master[1] -> Slots 5461 - 10922
Master[2] -> Slots 10923 - 16383
Adding replica 172.18.12.5:7005 to 172.18.12.1:7001
Adding replica 172.18.12.6:7006 to 172.18.12.2:7002
Adding replica 172.18.12.4:7004 to 172.18.12.3:7003
M: f158d1d7b0efb7e156de38ba535b530e09ed5829 172.18.12.1:7001
   slots:[0-5460] (5461 slots) master
M: 19e9645d1b9e75fe1622c5659e78f117cb0f3848 172.18.12.2:7002
   slots:[5461-10922] (5462 slots) master
M: 56588490b800d6436dd9fbf47eaf11207a1b09fe 172.18.12.3:7003
   slots:[10923-16383] (5461 slots) master
S: 48285efbf4bff6d4881e76fb227a8e2a13db2b69 172.18.12.4:7004
   replicates 56588490b800d6436dd9fbf47eaf11207a1b09fe
S: 619bdd5e1d2938ae285842866bee55b2a861731f 172.18.12.5:7005
   replicates f158d1d7b0efb7e156de38ba535b530e09ed5829
S: de5352a975bb71b4b566a29f7c7cbdc5c660ab71 172.18.12.6:7006
   replicates 19e9645d1b9e75fe1622c5659e78f117cb0f3848
Can I set the above configuration? (type 'yes' to accept): yes
>>> Nodes configuration updated
>>> Assign a different config epoch to each node
>>> Sending CLUSTER MEET messages to join the cluster
Waiting for the cluster to join
.
>>> Performing Cluster Check (using node 172.18.12.1:7001)
M: f158d1d7b0efb7e156de38ba535b530e09ed5829 172.18.12.1:7001
   slots:[0-5460] (5461 slots) master
   1 additional replica(s)
M: 19e9645d1b9e75fe1622c5659e78f117cb0f3848 172.18.12.2:7002
   slots:[5461-10922] (5462 slots) master
   1 additional replica(s)
M: 56588490b800d6436dd9fbf47eaf11207a1b09fe 172.18.12.3:7003
   slots:[10923-16383] (5461 slots) master
   1 additional replica(s)
S: 48285efbf4bff6d4881e76fb227a8e2a13db2b69 172.18.12.4:7004
   slots: (0 slots) slave
   replicates 56588490b800d6436dd9fbf47eaf11207a1b09fe
S: 619bdd5e1d2938ae285842866bee55b2a861731f 172.18.12.5:7005
   slots: (0 slots) slave
   replicates f158d1d7b0efb7e156de38ba535b530e09ed5829
S: de5352a975bb71b4b566a29f7c7cbdc5c660ab71 172.18.12.6:7006
   slots: (0 slots) slave
   replicates 19e9645d1b9e75fe1622c5659e78f117cb0f3848
[OK] All nodes agree about slots configuration.
>>> Check for open slots...
>>> Check slots coverage...
[OK] All 16384 slots covered.
```

## 集群访问

由于mac下不能通过host模式启动docker，因此访问
时需要登录进容器进行set操作  

```
root@545fbd0f8876:/data# redis-cli -c -p 7001
127.0.0.1:7001> set foo bar
-> Redirected to slot [12182] located at 172.18.12.3:7003
OK
172.18.12.3:7003> set hello word
-> Redirected to slot [866] located at 172.18.12.1:7001
OK
172.18.12.1:7001> get foo
-> Redirected to slot [12182] located at 172.18.12.3:7003
"bar"
172.18.12.3:7003> get hello
-> Redirected to slot [866] located at 172.18.12.1:7001
"word"
172.18.12.1:7001>
```
## 参考链接

[https://redis.io/topics/cluster-tutorial](https://redis.io/topics/cluster-tutorial)