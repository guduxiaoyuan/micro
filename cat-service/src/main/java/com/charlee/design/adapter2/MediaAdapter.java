/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月8日 上午10:21:43
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.adapter2;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description:
 * @date 2019年11月8日 上午10:21:43
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {

		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer = new VlcPlayer();

		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileName) {

		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer.playMp4(fileName);
		}
	}
	
}
