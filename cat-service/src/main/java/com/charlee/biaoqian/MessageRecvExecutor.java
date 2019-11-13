/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 上午8:37:46
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.biaoqian;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月29日 上午8:37:46
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@Configuration
public class MessageRecvExecutor implements ApplicationContextAware, InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("setApplicationContext");
	}

}
