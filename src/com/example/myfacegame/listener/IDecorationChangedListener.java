package com.example.myfacegame.listener;

/**
 * 用户点击人物装饰，通知mainview重绘接口
 * @author Mr.Euler
 *
 */
public interface IDecorationChangedListener {
	/**
	 * 
	 * @param index 图片更换的图层(哪个部位)
	 * @param resId 更换图片资源id
	 */
	public void onchanged(int index,int resId);
}
