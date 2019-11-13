/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月25日 上午10:15:37
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.controller;

import org.springframework.context.ApplicationEvent;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月25日 上午10:15:37
 * @Copyright 中国电信集团系统集成有限责任公司
 */


/**
 * @author jackcooper
 * @create 2018-02-27 13:54
 */
public class UserRegisterEvent extends ApplicationEvent {

    public User user;

    /**
     *
     * @param source 发生事件的对象
     * @param user 注册用户对象
     */
    public UserRegisterEvent(Object source,User user) {
        super(source);
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
