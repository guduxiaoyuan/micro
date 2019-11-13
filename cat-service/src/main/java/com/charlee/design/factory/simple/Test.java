/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 下午4:19:17
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.factory.simple;


/**
 * 普通工厂模式
 */
public class Test {

	public static void main(String[] args) {
		
		SenderFactory factory = new SenderFactory();
		Sender sender = factory.produce("mail");
		sender.send();
	}
}
