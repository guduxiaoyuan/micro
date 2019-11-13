/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年10月30日 下午4:28:36
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.Observer;


/***
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * @author jstao
 *
 */
public interface Observerable {
    
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
    
}