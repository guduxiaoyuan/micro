/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 上午8:25:02
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.biaoqian;



import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.charlee.controller.User;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected Class getBeanClass(Element element) {
        return User.class;
    }
    
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String userName = element.getAttribute("cname");
        if (StringUtils.hasText(userName)) {
            bean.addPropertyValue("cname", userName);
        }
        
    }
}