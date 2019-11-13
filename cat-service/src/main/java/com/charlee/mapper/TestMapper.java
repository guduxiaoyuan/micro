/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月28日 下午6:04:50
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.mapper;

import org.apache.ibatis.annotations.Delete;

import com.charlee.controller.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月28日 下午6:04:50
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@org.apache.ibatis.annotations.Mapper
public interface TestMapper extends Mapper<User>{
	
}
