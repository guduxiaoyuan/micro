/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月30日 下午4:54:08
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.MyObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description: 
 * @date 2019年10月30日 下午4:54:08
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class Observer {
	private List<Sss> sList ;
	
	public Observer(){
		sList = new ArrayList<Sss>();
	}
	
	public void regisObs(Sss s){
		sList.add(s);
	}
	
	public void delObs(Sss s){
		sList.remove(s);
	}
	
	public void notifyAllT(){
		for(Sss s : sList){
			s.receive();
		}
	}
	
}
