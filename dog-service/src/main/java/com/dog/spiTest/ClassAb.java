/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月31日 上午8:07:48
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.dog.spiTest;


/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月31日 上午8:07:48
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public abstract class ClassAb implements Intef{
	User user = new User();
	public ClassAb(){
		
		user = new User();
		user.setAge(1);
	};
	
	@Override
	public void aa() {
		System.out.println("ClassAb Interface>>>" + user.getAge());
	}
	
	public abstract void tt();
	
	public void xx(){
		System.out.println("xxxxx");
	};
	
}
