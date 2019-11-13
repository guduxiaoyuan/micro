/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月25日 上午10:18:04
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.controller;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月25日 上午10:18:04
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@Data
@Table(name = "Course")
public class User {
    @javax.persistence.Id @GeneratedValue(generator = "JDBC")
    @Column(name="Cid")
	private int cid;
    @Column(name="Cname")
	private String cname;
//	private String email;
}
