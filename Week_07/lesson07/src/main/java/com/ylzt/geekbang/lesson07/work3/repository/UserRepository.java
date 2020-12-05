package com.ylzt.geekbang.lesson07.work3.repository;

import com.ylzt.geekbang.lesson07.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserRepository
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/5 10:49 下午
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
