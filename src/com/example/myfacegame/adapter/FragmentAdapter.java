package com.example.myfacegame.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myfacegame.fragment.PagerFragment;
import com.example.myfacegame.view.MainView;

public class FragmentAdapter extends FragmentPagerAdapter{
	private boolean sex;
	private MainView mainView;
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public FragmentAdapter(FragmentManager fm,boolean sex,MainView view) {
		super(fm);
		this.sex=sex;
		this.mainView=view;
	}
	@Override
	public Fragment getItem(int position) {
		
		PagerFragment pf=new PagerFragment();
		Bundle bundle=new Bundle();
		bundle.putInt("index", position);
		bundle.putBoolean("sex", sex);
		pf.setArguments(bundle);
		pf.setChangedListener(mainView);
		return pf;
	}

	@Override
	public int getCount() {
		return 11;
	}

}
