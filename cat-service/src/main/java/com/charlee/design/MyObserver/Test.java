/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月30日 下午4:56:54
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.MyObserver;


/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月30日 下午4:56:54
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class Test {
	
	public static void main(String[] args) {
		Sss s1 = new Sss1();
		
		Observer o = new Observer();
		o.regisObs(s1);
		o.regisObs(new Sss2());
		
		o.notifyAllT();
		
		o.delObs(s1);
		o.notifyAllT();
	}
	
}
