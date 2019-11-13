/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月8日 下午2:32:46
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.adapter;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description:
 * @date 2019年11月8日 下午2:32:46
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class Adapter extends Adaptee implements Target {
	@Override
	public void method2() {
		System.out.println("method 2");
	}
}

// 测试
class AdapterTest {
	public static void main(String[] args) {
		Adapter adapter = new Adapter();
		adapter.method1();
		adapter.method2();
	}
}
