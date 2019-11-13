/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月30日 下午4:35:55
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.Observer;


public class Test {
    
    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        
        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");
        
        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");
        
        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");
        
    }
}