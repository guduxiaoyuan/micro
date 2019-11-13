package com.charlee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.charlee.design.stragy.ImplA;
import com.charlee.design.stragy.SimpleContext;
import com.charlee.mapper.TestMapper;

/**
 * @author charlee
 * @date 2018/5/14
 */
@RestController
@Scope("prototype")
public class CatController {
	
	@Autowired
	TestMapper testMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	SimpleContext simpleContext;
	
	@Autowired
	ConfigCenterBuilder builder;
	
	
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
    	User user = new User();
    	ConfigCenterBuilder e = new ConfigCenterBuilder();
    	
    	ConfigCenterConfig cfg = e.namespace("a").build();
    	
    	System.out.println(cfg.getProtocol());
    	
//    	userService.register(user);
//    	
//    	user.setCid(01);
//    	
//    	
//    	Example example = new Example(User.class);
//    	tk.mybatis.mapper.entity.Example.Criteria c = example.createCriteria();
//    	c.andEqualTo("cid", "01");
//    	List l = testMapper.selectByExample(example);
//    	System.out.println(">");
//    	ApplicationContext beans=new ClassPathXmlApplicationContext("classpath:test.xml");    
//    	User user=(User)beans.getBean("testbean");    
//    	System.out.println("username:"+user.getCname());    
//    	simpleContext.doSome("implA");
//    	simpleContext.doSome("implB");
    	
        return "hello, " + name;
    }
}
