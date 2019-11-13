/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月31日 下午2:45:08
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.dog.spiTest;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description:
 * @date 2019年10月31日 下午2:45:08
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class Holder<T> {
	private volatile T value;

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}
	
	
	public static void main(String[] args) {
		
		User u = new User();
		u.setAge(11);
		
		Holder<User> t = new Holder<User>();
		t.set(u);
		
		
		User uu = t.get();
		
		System.out.println(uu.getAge());
	}
}
