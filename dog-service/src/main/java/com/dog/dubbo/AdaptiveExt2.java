/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月1日 上午8:12:23
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.dog.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年11月1日 上午8:12:23
 * @Copyright 中国电信集团系统集成有限责任公司
 */

@SPI("dubbo")
public interface AdaptiveExt2 {
    @Adaptive
    String echo(String msg, URL url);
}
