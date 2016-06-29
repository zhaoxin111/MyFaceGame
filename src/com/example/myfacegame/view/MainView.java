package com.example.myfacegame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.example.myfacegame.listener.IDecorationChangedListener;
import com.example.myfacegame.util.MyRes;

/**
 * 
 * @author Mr.Euler
 * 
 */
public class MainView extends View implements IDecorationChangedListener{
	private int ids[];
	private Bitmap bitmaps[];
	private boolean sex;
	private int view_width, view_height;

	public MainView(Context context) {
		super(context);
	}

	public MainView(Context context, boolean sex) {
		super(context);
		this.sex = sex;
		initBitmaps();
		//设置允许获取view,用于保存图片
		this.setDrawingCacheEnabled(true);
	}

	private void initBitmaps() {
		if (sex) {
			ids = MyRes.getBoyDefault();
		} else {
			ids = MyRes.getGirlDefault();
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (view_width == 0 || view_height == 0) {
			view_width = canvas.getWidth();
			view_height = canvas.getHeight();
		}

		getBitmaps();

		drawBitmaps(canvas);
	}

	private void drawBitmaps(Canvas canvas) {
		// 根据图层顺序绘制图片
		// 先画背景
		canvas.drawBitmap(bitmaps[10], 0, 0, null);
		// 再绘制五官
		canvas.drawBitmap(bitmaps[1], (view_width - bitmaps[1].getWidth()) / 2,
				(view_height - bitmaps[1].getHeight()) / 2, null);
		canvas.drawBitmap(bitmaps[2], (view_width - bitmaps[2].getWidth()) / 2,
				(view_height - bitmaps[2].getHeight()) / 2, null);
		canvas.drawBitmap(bitmaps[3], (view_width - bitmaps[3].getWidth()) / 2,
				(view_height - bitmaps[2].getHeight()) / 2 + view_height / 15,
				null);
		canvas.drawBitmap(bitmaps[4], (view_width - bitmaps[4].getWidth()) / 2,
				11 * view_height / 20, null);
		canvas.drawBitmap(bitmaps[5], (view_width - bitmaps[5].getWidth()) / 2,
				(view_height - bitmaps[5].getHeight()) / 2, null);
		canvas.drawBitmap(bitmaps[6], (view_width - bitmaps[6].getWidth()) / 2,
				(view_height - bitmaps[6].getHeight()) / 2 + view_height / 20,
				null);
		canvas.drawBitmap(bitmaps[7], (view_width - bitmaps[7].getWidth()) / 2,
				view_height - bitmaps[7].getHeight(), null);
		// 最后绘制发型，画在控件中心位置
		canvas.drawBitmap(bitmaps[0], (view_width - bitmaps[0].getWidth()) / 2,
				(view_height - bitmaps[0].getHeight()) / 2, null);
	}

	/**
	 * 根据图片id获取所有图片
	 */
	private void getBitmaps() {
		bitmaps = new Bitmap[ids.length];
		for (int i = 0; i < ids.length; i++) {
			bitmaps[i] = BitmapFactory.decodeResource(getResources(), ids[i]);
		}

		// 获得合适大小的图片
		bitmaps[0] = Bitmap.createScaledBitmap(bitmaps[0], 2 * view_width / 3,
				2 * view_width / 3, false);
		bitmaps[1] = Bitmap.createScaledBitmap(bitmaps[1], 2 * view_width / 3,
				2 * view_width / 3, false);
		bitmaps[2] = Bitmap.createScaledBitmap(bitmaps[2], view_width / 3,
				view_width / 3, false);
		bitmaps[3] = Bitmap.createScaledBitmap(bitmaps[3], 3 * view_width / 10,
				3 * view_width / 10, false);
		bitmaps[4] = Bitmap.createScaledBitmap(bitmaps[4], view_width / 5,
				view_width / 5, false);
		bitmaps[5] = Bitmap.createScaledBitmap(bitmaps[5], view_width / 2,
				view_width / 2, false);
		bitmaps[6] = Bitmap.createScaledBitmap(bitmaps[6], view_width / 3,
				view_width / 3, false);
		bitmaps[7] = Bitmap.createScaledBitmap(bitmaps[7], 5 * view_width / 11,
				5 * view_width / 11, false);
		bitmaps[10] = Bitmap.createScaledBitmap(bitmaps[10], view_width,
				view_height, false);
	}

	@Override
	public void onchanged(int index, int resId) {
		ids[index]=resId;
		//重绘
		invalidate();
	}

}
