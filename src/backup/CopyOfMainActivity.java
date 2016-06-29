package backup;

import java.util.ArrayList;
import java.util.List;

import com.example.myfacegame.R;
import com.example.myfacegame.R.drawable;
import com.example.myfacegame.R.id;
import com.example.myfacegame.R.layout;
import com.example.myfacegame.adapter.GridAdapter;
import com.example.myfacegame.adapter.MyPagerAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

public class CopyOfMainActivity extends Activity {
	
	private GridView gridView;
	private List<Integer> resIds = new ArrayList<>();
	private GridAdapter adapter;
	private ViewPager viewPager;
	private List<View> pagerViews = new ArrayList<>();
	private LayoutInflater layoutInflater;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// initGridView();
		initViewPager();
	}
	private void initViewPager() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		getViewPagerData();
		
		MyPagerAdapter myPagerAdapter=new MyPagerAdapter(pagerViews);
		viewPager.setAdapter(myPagerAdapter);
		
	}

	private void getViewPagerData() {
		layoutInflater=LayoutInflater.from(this);
		View page1= layoutInflater.inflate(R.layout.page1, null);
		View page2=layoutInflater.inflate(R.layout.page2, null);
		View page3=layoutInflater.inflate(R.layout.page3, null);
		View page4=layoutInflater.inflate(R.layout.page4, null);
		
		pagerViews.add(page1);
		pagerViews.add(page2);
		pagerViews.add(page3);
		pagerViews.add(page4);
	}

	private void initGridView() {
		// 1.获取控件
		gridView = (GridView) findViewById(R.id.gridView);
		// 2.获取数据
		getGridViewData();
		// 3.创建适配器
		adapter = new GridAdapter(resIds, this);
		// 4.将适配器绑定到控件
		gridView.setAdapter(adapter);
	}

	private void getGridViewData() {
		resIds.add(R.drawable.pic_s1_0);
		resIds.add(R.drawable.pic_s1_2);
		resIds.add(R.drawable.pic_s1_3);
		resIds.add(R.drawable.pic_s1_4);
		resIds.add(R.drawable.pic_s1_5);
		resIds.add(R.drawable.pic_s1_6);
		resIds.add(R.drawable.pic_s1_7);
		resIds.add(R.drawable.pic_s1_8);
		resIds.add(R.drawable.pic_s1_9);
		resIds.add(R.drawable.pic_s1_10);
		resIds.add(R.drawable.pic_s1_11);
		resIds.add(R.drawable.pic_s1_12);
		resIds.add(R.drawable.pic_s1_13);
		resIds.add(R.drawable.pic_s1_14);
		resIds.add(R.drawable.pic_s1_15);
		resIds.add(R.drawable.pic_s1_16);
		resIds.add(R.drawable.pic_s1_17);
		resIds.add(R.drawable.pic_s1_18);
		resIds.add(R.drawable.pic_s1_19);
		resIds.add(R.drawable.pic_s1_20);
		resIds.add(R.drawable.pic_s1_21);
		resIds.add(R.drawable.pic_s1_22);
		resIds.add(R.drawable.pic_s1_23);
		resIds.add(R.drawable.pic_s1_24);
		resIds.add(R.drawable.pic_s1_25);
		resIds.add(R.drawable.pic_s1_26);
		resIds.add(R.drawable.pic_s1_27);
		resIds.add(R.drawable.pic_s1_28);
		resIds.add(R.drawable.pic_s1_29);
		resIds.add(R.drawable.pic_s1_30);
		resIds.add(R.drawable.pic_s1_31);
		resIds.add(R.drawable.pic_s1_32);
		resIds.add(R.drawable.pic_s1_33);
		resIds.add(R.drawable.pic_s1_34);

	}
}
