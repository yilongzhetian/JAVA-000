package com.ylzt.geekbang.lesson07.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/5 10:40 下午
 **/
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    @Column(name="created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updatedTime;


}
