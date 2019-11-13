/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月30日 下午3:05:02
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.stragy;

import org.springframework.stereotype.Component;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月30日 下午3:05:02
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@Component
public class ImplB implements Strategy{

	/* (non-Javadoc)
	 * @see com.charlee.design.stragy.Strategy#tt()
	 */
	@Override
	public void tt() {
		// TODO Auto-generated method stub
		System.out.println("BBBBBBBBBBBBBBBBBBB");
	}

}
