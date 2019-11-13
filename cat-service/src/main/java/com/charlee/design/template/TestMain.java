/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月8日 上午9:40:11
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.template;


/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年11月8日 上午9:40:11
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class TestMain {

	public static void main(String[] args) {
		
		Interff a = new Impl1();
		a.doSomeThing();
		Interff b = new Impl2();
		b.doSomeThing();
		
	}
}
