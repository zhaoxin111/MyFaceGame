package com.example.myfacegame;

import com.example.myfacegame.util.AnimationUtils;
import com.example.myfacegame.util.SoundUtil;

import android.R.transition;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
/**
 * 登录首界面
 * @author Mr.Euler
 *
 */
public class LoginActivity extends Activity implements OnClickListener {
	private Button bt_sound,bt_man,bt_woman,bt_gif,bt_more;
	boolean isSoundOpen=true;//是否打开音乐
	SoundPool soundPool;//声音池
	int music_boy,music_girl;
	private SoundUtil soundUtil;//声音工具类
	private ImageView img_startPage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
	}
	
	public void init(){
		bt_gif=(Button) findViewById(R.id.bt_gif);
		bt_more=(Button) findViewById(R.id.bt_more);
		img_startPage=(ImageView) findViewById(R.id.img_startpage);
		soundUtil=SoundUtil.getInstance(LoginActivity.this);
		bt_sound=(Button) findViewById(R.id.bt_sound);
		bt_woman=(Button) findViewById(R.id.bt_woman);
		bt_man=(Button) findViewById(R.id.bt_man);
		startAnimation();
		
		bt_man.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action= event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					bt_man.setBackgroundResource(R.drawable.bt_man_down);
					soundUtil.playBoySound();
					Intent intent=new Intent(LoginActivity.this,MainActivity.class);
					intent.putExtra("sex", true);
					startActivity(intent);
					//finish();
					break;
				case MotionEvent.ACTION_UP:
					bt_man.setBackgroundResource(R.drawable.bt_man_up);
					
				break;
				default:
					break;
				}
				return false;
			}
		});
		bt_woman.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action= event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					bt_woman.setBackgroundResource(R.drawable.bt_woman_down);
					soundUtil.playGirlSound();
					Intent intent=new Intent(LoginActivity.this,MainActivity.class);
					intent.putExtra("sex", false);
					startActivity(intent);
					//finish();
					break;
				case MotionEvent.ACTION_UP:
					bt_woman.setBackgroundResource(R.drawable.bt_woman_up);
				break;
				default:
					break;
				}
				return false;
			}
		});
		bt_sound.setOnClickListener(this);
		bt_man.setOnClickListener(this);
		bt_woman.setOnClickListener(this);
		soundPool=new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
		music_boy=soundPool.load(this, R.raw.boy, 1);
		music_girl=soundPool.load(this, R.raw.girl,1);
	}
	/**
	 * 首界面的图片动画效果
	 */
	private void startAnimation() {
		/*
		AnimationUtils.startRotaAnim(bt_man, 1000*3);
		TranslateAnimation ta=new TranslateAnimation(-300f, 0, 0, 0);
		TranslateAnimation ta2=new TranslateAnimation(300, 0, 0, 0);
		bt_man.bringToFront();
		bt_woman.bringToFront();
		ta.setDuration(1000*3);
		ta2.setDuration(1000*3);
		bt_woman.startAnimation(ta2);
		bt_man.startAnimation(ta);
		
		AnimationUtils.startRotaAnim(img_startPage, 1000*4);
		*/
		
		AnimationUtils.startAlphaAnim(bt_man,1000*3);
		AnimationUtils.startTransAnim2(bt_woman, 3000);
		AnimationUtils.startTransAnim3(bt_more,1000*3);
//		参数false表示使用自己的动画
		AnimationSet anim_set = new AnimationSet(true);
		ScaleAnimation as = (ScaleAnimation) AnimationUtils.startScaleAnim(img_startPage,3000);
		TranslateAnimation ta = (TranslateAnimation) AnimationUtils.startTransAnim(img_startPage, 3000);
		anim_set.addAnimation(as);
		anim_set.addAnimation(ta);
		img_startPage.startAnimation(anim_set);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_sound:
			
			isSoundOpen=!isSoundOpen;
			if(isSoundOpen){
				bt_sound.setBackgroundResource(R.drawable.bt_homepage_sound_on);
				
			}else {
				bt_sound.setBackgroundResource(R.drawable.bt_homepage_sound_off);
			}
			break;
		default:
			break;
		}
	}
}
