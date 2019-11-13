/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月31日 下午3:29:19
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.builderTest;

import java.io.Console;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月31日 下午3:29:19
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class TestMain {
	
	public static void main(String[] args) {
		Computer cpu = new Computer.ComputerBuilder().buildCPU("cpu").buildDisplayCard("xx").build();
	}
}
