package com.example.myfacegame.util;

import com.example.myfacegame.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundUtil {
	private  SoundPool soundPool;
	static int music_boy, music_girl, music_succeed;
	private static SoundUtil instance=null;

	@SuppressWarnings("deprecation")
	public SoundUtil(Context context) {
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		music_boy = soundPool.load(context, R.raw.boy, 5);
		music_girl = soundPool.load(context, R.raw.girl, 5);
		music_succeed = soundPool.load(context, R.raw.save_succeed, 5);
	}

	public static synchronized SoundUtil getInstance(Context context) {
		if (instance == null) {
			instance = new SoundUtil(context);
		}
		return instance;
	}

	public  void playBoySound() {
		soundPool.play(music_boy, 1.0f, 1.0f, 1, 0, 1);
	}

	public  void playGirlSound() {
		soundPool.play(music_girl, 1.0f, 1.0f, 1, 0, 1);
	}

	public  void playCucceedSound() {
		soundPool.play(music_succeed, 1.0f, 1.0f, 1, 0, 1);
	}
	
	public  void releaseSound(){
		soundPool.release();
		soundPool=null;
		instance=null;
	}
}
