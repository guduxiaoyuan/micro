/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 下午4:16:53
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.factory.simple;


/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月29日 下午4:16:53
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class SenderFactory {

	public Sender produce(String type){
		if("mail".equals(type)){
			return new MailSender();
		}else if ("sms".equals(type)){
			return new SmsSender();
		}else {
			System.out.println("类型不匹配");
			return null;
		}
		
	}
	
}
