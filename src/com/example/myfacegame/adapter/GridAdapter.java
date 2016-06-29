package com.example.myfacegame.adapter;

import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

	private List<Integer> resIds;
	private Context context;

	public GridAdapter(List<Integer> resIds, Context context) {
		this.resIds=resIds;
		this.context=context;
	}

	@Override
	public int getCount() {
		return resIds.size();
	}

	@Override
	public Object getItem(int position) {
		return resIds.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		int resId = resIds.get(position);

		ImageView imageView = new ImageView(context);
		imageView.setBackgroundColor(Color.WHITE);
		imageView.setImageResource(resId);

		return imageView;
	}

}
