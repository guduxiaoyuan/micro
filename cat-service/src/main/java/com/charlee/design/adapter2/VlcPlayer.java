/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月8日 上午10:21:03
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.adapter2;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description:
 * @date 2019年11月8日 上午10:21:03
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class VlcPlayer implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// do nothing
	}

}
