package com.lrm.dao;

import com.lrm.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2021/10/11.
 */
public interface UserRepository extends JpaRepository<User,Long> {//直接可以操作数据库
    User findByUsernameAndPassword(String username,String password);
}
