/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月31日 下午3:07:17
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.dog.spiTest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月31日 下午3:07:17
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class Clasloader extends ClassLoader{
	/**
	 * class文件的路径
	 */
	private String path;
 
	public Clasloader(String path) {
		this.path = path;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classPath = path + name + ".class";
		try (InputStream in = new FileInputStream(classPath)) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int i = 0;
			while ((i = in.read()) != -1) {
				out.write(i);
			}
			byte[] byteArray = out.toByteArray();
			return defineClass(byteArray, 0, byteArray.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return null;
 
	}

}
