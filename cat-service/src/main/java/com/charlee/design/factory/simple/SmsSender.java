/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 下午4:16:25
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.factory.simple;


/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月29日 下午4:16:25
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println("发送短信");
	}

}
