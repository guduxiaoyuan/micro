/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月31日 上午8:09:53
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.dog.spiTest;


/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月31日 上午8:09:53
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class ClasBb extends ClassAb{

	@Override
	public void tt() {
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Intef i = new Intef() {
			
			@Override
			public void aa() {
				System.out.println("bbb");
				
			}
		};
		i.aa();
		
//		Clasloader lo = new Clasloader(path);
		
	}
}
