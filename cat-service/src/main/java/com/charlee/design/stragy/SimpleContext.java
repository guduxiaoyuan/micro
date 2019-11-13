/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月30日 下午3:05:58
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.stragy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月30日 下午3:05:58
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@Service
public class SimpleContext {
	
    private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();
 
	@Autowired
    public SimpleContext(Map<String, Strategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
    }

	public void doSome(String id){
		strategyMap.get(id).tt();
	}
}
