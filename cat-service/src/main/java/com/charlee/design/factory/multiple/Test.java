/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 下午4:23:28
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.factory.multiple;

import com.charlee.design.factory.simple.Sender;

/**
 * 
 *多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
 */

public class Test {
	
	public static void main(String[] args) {
		SenderMulFactory factory = new SenderMulFactory();
		Sender sender = factory.produceMail();
		sender.send();
	}
}
