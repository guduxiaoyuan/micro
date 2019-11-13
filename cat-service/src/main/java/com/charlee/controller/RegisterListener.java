/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月25日 上午10:17:31
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月25日 上午10:17:31
 * @Copyright 中国电信集团系统集成有限责任公司
 */

@Component
public class RegisterListener implements ApplicationListener<UserRegisterEvent> {

    /**
     * 实现监听
     * @param userRegisterEvent
     */
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        //获取注册用户对象
        User user = userRegisterEvent.getUser();

        //../省略逻辑

        //输出注册用户信息
        System.out.println("2注册信息，用户名："+user.getCname());
    }
}

