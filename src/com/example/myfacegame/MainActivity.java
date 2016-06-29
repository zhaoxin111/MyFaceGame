package com.example.myfacegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myfacegame.adapter.FragmentAdapter;
import com.example.myfacegame.view.MainView;

public class MainActivity extends FragmentActivity {

	private RadioGroup radioGroup;
	private RadioButton radioButton;
	private HorizontalScrollView hsv;// 水平滑动栏
	private ViewPager viewPager;
	private TextView cursor;// 游标
	private boolean sex;
	private Button bt_back,bt_save;
	private MainView mainView;//自定义绘图
	private RelativeLayout rl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initHsv();
		initSex();
		// 初试化tab选择栏
		initTab();
		// 初始化游标
		initCursor();
		// 初试化viewpager
		initView();
		initPager();
		initButton();
	}
	/**
	 * 创建核心绘制区域
	 */
	private void initView() {
		mainView=new MainView(this, sex);
		rl=(RelativeLayout) findViewById(R.id.rl);
		rl.addView(mainView);
	}

	private void initButton() {
		bt_back=(Button) findViewById(R.id.bt_back);
		bt_save=(Button) findViewById(R.id.bt_save);
		
		bt_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		bt_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Bitmap bitmap=mainView.getDrawingCache();
				File file =new File(Environment.getExternalStorageDirectory(), "lianMeng.png");
				try {
					bitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(file));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 初始化水平滑动栏
	 */
	private void initHsv() {
		hsv = (HorizontalScrollView) findViewById(R.id.hsv);
	}

	/**
	 * 获取性别
	 */
	private void initSex() {
		Intent intent = getIntent();
		sex = intent.getBooleanExtra("sex", true);
	}

	/**
	 * 初始化游标
	 */
	private void initCursor() {
		cursor = (TextView) findViewById(R.id.cursorview);
	}

	/**
	 * 初试化viewpager
	 */
	@SuppressWarnings("deprecation")
	private void initPager() {
		// 获取控件
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		FragmentAdapter fragmentAdapter = new FragmentAdapter(
				getSupportFragmentManager(),sex,mainView);
		// 绑定适配器
		viewPager.setAdapter(fragmentAdapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// position表示当前页面的序号
				/**
				 * positionOffset 当前滑动比例
				 * 如果从左往右划，那么offset从0到1(翻页后变为0).若由右向左划，那么offset由1到0
				 */
				// Log.d("onPageScrolled",
				// "pos="+position+"    offset="+positionOffset);
				int radioBtWidth = radioButton.getWidth();
				int newposition = (int) (position * radioBtWidth + positionOffset
						* radioBtWidth);
				int center = (viewPager.getWidth() - radioBtWidth) / 2;
				hsv.scrollTo(newposition - center, 0);
				// Log.d("onPageScrolled",
				// "newpos="+newposition+"   scrollto="+(newposition-center));
				startMoveCursor(position, positionOffset);
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});

	}

	private int from = 0;

	/**
	 * 控制游标移动
	 * 
	 * @param position
	 *            当前移动的位置
	 * @param positionOffset
	 *            当前移动的百分比
	 */
	protected void startMoveCursor(int position, float positionOffset) {
		// 获取当前被选中的radiobutton
		RadioButton rb = (RadioButton) radioGroup.getChildAt(position);
		// 定义两个长度的数组 0下标 代表x坐标 1下标y坐标
		int[] location = new int[2];
		// 获取当前radiobutton的坐标
		rb.getLocationInWindow(location);

		// 计算移动后的坐标
		int to = (int) (location[0] + positionOffset * rb.getWidth());

		// 创建动画
		TranslateAnimation ta = new TranslateAnimation(from, to, 0, 0);
		ta.setDuration(100);
		// 动画完成以后停留在当前结束的位置
		ta.setFillAfter(true);

		cursor.startAnimation(ta);
		from = to;

	}

	/**
	 * 初试化tab选择栏
	 */
	private void initTab() {
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		radioButton = (RadioButton) findViewById(R.id.rb1);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb1:
					viewPager.setCurrentItem(0);
					break;
				case R.id.rb2:
					viewPager.setCurrentItem(1);
					break;
				case R.id.rb3:
					viewPager.setCurrentItem(2);
					break;
				case R.id.rb4:
					viewPager.setCurrentItem(3);
					break;
				case R.id.rb5:
					viewPager.setCurrentItem(4);
					break;
				case R.id.rb6:
					viewPager.setCurrentItem(5);
					break;
				case R.id.rb7:
					viewPager.setCurrentItem(6);
					break;
				case R.id.rb8:
					viewPager.setCurrentItem(7);
					break;
				case R.id.rb9:
					viewPager.setCurrentItem(8);
					break;
				case R.id.rb10:
					viewPager.setCurrentItem(9);
					break;
				case R.id.rb11:
					viewPager.setCurrentItem(10);
					break;
					
				default:
					break;
				}
			}
		});
	}
}
