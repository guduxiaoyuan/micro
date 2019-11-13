/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月29日 下午5:11:07
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.builder;


/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月29日 下午5:11:07
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class PersonBuilder {
	
	private Person person;
	
	public PersonBuilder(){
		person = new Person();
	}
	
	public PersonBuilder age(int age){
		person.setAge(age);
		return this;
	}
	
	public Person build(){
		return person;
	}
	
	
	public static void main(String[] args) {
		PersonBuilder p = new PersonBuilder();
		Person pp = p.age(1).build();
		
		System.out.println(pp.getAge());
	}
}
