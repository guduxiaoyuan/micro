/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 上午8:25:50
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.biaoqian;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {

        registerBeanDefinitionParser("user2", new UserBeanDefinitionParser());
    }

}
