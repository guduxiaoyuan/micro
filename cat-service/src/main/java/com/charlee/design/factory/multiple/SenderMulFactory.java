/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 下午4:22:29
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.factory.multiple;

import com.charlee.design.factory.simple.MailSender;
import com.charlee.design.factory.simple.Sender;
import com.charlee.design.factory.simple.SmsSender;

/**
 * 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
public class SenderMulFactory {
	
	public Sender produceMail(){
		return new MailSender();
	}
	
	public Sender produceSms(){
		return new SmsSender();
	}
}
