package com.lrm.service;

import com.lrm.blog.po.User;

/**
 * Created by Administrator on 2021/10/11.
 */
public interface UserService {
    User checkUser(String username,String password);


}
