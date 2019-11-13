/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月25日 上午10:16:31
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private ApplicationContext applicationContext;

    public void register(User user){
        //省略业务逻辑
        //。。。。
        //发布UserRegisterEvent事件
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
    }
  
}
