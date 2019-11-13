/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月30日 下午4:35:37
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.Observer;

/**
 * 观察者
 * 实现了update方法
 * @author jstao
 *
 */
public class User implements Observer {

    private String name;
    private String message;
    
    public User(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String message) {
        this.message = message;
        System.out.println(name + " 收到推送消息： " + message);
    }
    
}