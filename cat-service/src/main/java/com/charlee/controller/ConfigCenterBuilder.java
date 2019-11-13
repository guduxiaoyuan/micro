/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月10日 下午6:09:14
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description:
 * @date 2019年11月10日 下午6:09:14
 * @Copyright 中国电信集团系统集成有限责任公司
 */

@Component
@Data
@Scope("prototype")
public class ConfigCenterBuilder {
	
	private String a;
	
	private String b;
	
	  public ConfigCenterBuilder namespace(String a) {
	        this.a = a;
	        return getThis();
	    }
	
	  
	  public ConfigCenterConfig build() {
	        ConfigCenterConfig configCenter = new ConfigCenterConfig();

	        configCenter.setProtocol(a);

	        return configCenter;
	    }
	  

	protected ConfigCenterBuilder getThis() {
		return this;
	}

}
