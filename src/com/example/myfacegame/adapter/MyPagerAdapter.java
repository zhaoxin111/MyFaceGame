package com.example.myfacegame.adapter;

import java.util.List;

import com.example.myfacegame.LoginActivity;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {

	private List<View> pagerViews;
	public MyPagerAdapter(List<View> pagerViews) {
		this.pagerViews=pagerViews;
	}
	
	@Override
	public int getCount() {
		return pagerViews.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(pagerViews.get(position));
		Log.d("pager", "instantiateItem"+position);
		return pagerViews.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(pagerViews.get(position));
		Log.d("pager", "destroyItem"+position);
	}
}
