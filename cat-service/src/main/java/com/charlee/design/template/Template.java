/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月8日 上午9:38:11
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.template;


/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年11月8日 上午9:38:11
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public abstract class Template implements Interff {
	
	abstract void t1();
	
	abstract void t2();
	
	void t3(){
		System.out.println("第三个步骤");
	}
	
	void t4(){
		System.out.println("第四个步骤");
	}
	
	@Override
	public void doSomeThing(){
		t1();
		t2();
		t3();
		t4();
	}
	
}
