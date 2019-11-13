/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月1日 上午8:12:50
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.dog.dubbo;


import com.alibaba.dubbo.common.URL;
/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年11月1日 上午8:12:50
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class DubboAdaptiveExt2 implements AdaptiveExt2 {

    public String echo(String msg, URL url) {
        return "dubbo";
    }
    
    private DubboAdaptiveExt2(){
    	
    };
    
    
}
