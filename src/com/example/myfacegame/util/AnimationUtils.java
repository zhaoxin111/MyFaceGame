package com.example.myfacegame.util;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class AnimationUtils {
	private  Animation animation;
	private static AlphaAnimation aa;
	private static RotateAnimation ra;
	private static ScaleAnimation sa;
	private static TranslateAnimation ta;
	/**
	 * 
	 * @param view  需要动画效果的view
	 * @param time  动画持续的时间
	 */
	public static void startAlphaAnim(View view,int time){
		aa=new AlphaAnimation(0.0f,1.0f);
		aa.setDuration(time);
		view.startAnimation(aa);
	}
	
	public static void startRotaAnim(View view ,int time){
		
		/**
		 * 开始旋转的角度，旋转结束的角度，当前X参考点的类型，参考点X的坐标,当前Y参考点的类型，参考点Y的坐标
		 * Animation.ABSOLUTE     绝对坐标类型
		 *  Animation.RELATIVE_TO_SELF   相对自身坐标类型  这里0.5f就表示图片自身的中心
		 *  or Animation.RELATIVE_TO_PARENT   相对于父容器坐标类型
		 */
		ra=new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(time);
		view.startAnimation(ra);
	}
	
	public static void startScalAnim(View view,int time){
		sa=new ScaleAnimation(0.1f, 1.0f, 0.1f,1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
		sa.setDuration(time);
		view.startAnimation(sa);
	}
	
	public static void startTranAnim(View view, int time,int fromXType,int fromXValue,int toXType,int toXValue,int fromYType,int fromYValue,int toYType,int toYValue){
		ta=new TranslateAnimation(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue, toYType, toYValue);
		ta.setFillAfter(true);
		ta.setDuration(time);
		view.startAnimation(ta);
	}
	
	public static Animation startTransAnim2(View view,int time) {
		ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
		ta.setDuration(time);
		ta.setInterpolator(new AccelerateInterpolator());
		view.startAnimation(ta);
		return ta;
	}
	
//	开始移动动画
	public static Animation startTransAnim3(View view,int time) {
		ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 2, Animation.RELATIVE_TO_PARENT, 1,Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
		ta.setDuration(time);
		ta.setInterpolator(new AccelerateInterpolator());
		view.startAnimation(ta);
		return ta;
	}
	
//	缩放动画
	public static Animation startScaleAnim(View view,int time) {
		sa = new ScaleAnimation(0, 1.0f, 0, 1.0f);
		sa.setDuration(time);
		view.startAnimation(sa);
		return sa;
		
	}
	
//	开始移动动画
	public static Animation startTransAnim(View view,int time) {
		ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0);
		ta.setDuration(time);
		ta.setInterpolator(new AccelerateInterpolator());
		view.startAnimation(ta);
		return ta;
	}
}
