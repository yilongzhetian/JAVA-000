# 用户表

```
create table t_user(
    id                  bigint             primary_key         auto_increment   comment ‘用户id’,
    name                varchar(100)  		 not null            comment ‘姓名’,
    phone               varchar(20)    		 not null            comment ‘手机号’,
    created_time        datetime        	 not null            comment '创建时间’,
    updated_time        datetime        	 not null            comment ‘更新时间’
);
```

# 用户地址表

```
create table t_user_address(
        id                 bigint             primary_key    auto_increment   comment ‘用户地址id’,
        user_id            bigint             not null       comment ‘用户id’,
        address            varchar(200)       not null       comment ‘收货地址’,
        created_time       datetime           not null       comment '创建时间’,
        updated_time       datetime           not null       comment ‘更新时间’
) ;
alert table t_user_address add index idx_t_user_address_uid(user_id);
```

# 商品表
```
create table t_good(
    id                 bigint             primary_key         auto_increment   comment ‘商品id’,
    name               varchar(100)       not null            comment ‘商品名称’,
    price              double             not null            comment '商品价格’,
    amount             int                not null            comment ’商品数量’,
    created_time       datetime           not null            comment '创建时间’,
    updated_time       datetime           not null            comment ‘更新时间’
);
```

# 订单表
```
create table t_order(
    id                  bigint             primary_key         auto_increment   comment ‘自增id’,
    order_id            varchar(50)        not null            comment ‘订单号’,
    user_id             bigint             not null            comment ‘用户id’,
    good_id             bigint             not null            comment ‘商品id’,
    user_address_id     bigint             not null            comment ‘收货地址id’,
    amount              int                not null            comment ’商品数量’,
    created_time        datetime           not null            comment '创建时间’,
    updated_time        datetime           not null            comment ‘更新时间’
);
alert table t_order add index idx_t_order_uid(user_id);
alert table t_order add index idx_t_order_oid(order_id);
alert table t_order add index idx_t_order_aid(user_address_id);
```