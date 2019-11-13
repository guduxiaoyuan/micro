/**
 * @author zhaohy
 * @version V1.0.1
 * @Description: TODO
 * @date 2019年11月8日 上午10:22:25
 * @Copyright 中国电信集团系统集成有限责任公司
 */
package com.charlee.design.adapter2;

/**
 * @author ZHAOHY
 * @version V1.0.1
 * @Description:
 * @date 2019年11月8日 上午10:22:25
 * @Copyright 中国电信集团系统集成有限责任公司
 */

public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {

		// inbuilt support to play mp3 music files
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file. Name: " + fileName);
		}

		// mediaAdapter is providing support to play other file formats
		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}

		else {
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
	}
}
