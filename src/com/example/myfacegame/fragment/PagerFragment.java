package com.example.myfacegame.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Identity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.myfacegame.R;
import com.example.myfacegame.adapter.GridAdapter;
import com.example.myfacegame.listener.IDecorationChangedListener;
import com.example.myfacegame.util.MyRes;
import com.example.myfacegame.view.MainView;

public class PagerFragment extends Fragment{
	
	private View view;
	private List<Integer> resIds=new ArrayList<>();//图片资源
	private Context context;
	private GridView gridView;
	private int index;//当前viewpager的序号
	private int ids[];//图片资源id
	private boolean sex;
	private IDecorationChangedListener idcListener;
	/**
	 * 与之关联的activity在oncreate调用完调用此方法
	 */
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initGridView();
	}
	
	/**
	 * fragment被创建时调用
	 */
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.layout_fragment, container, false);
		return view;
	}

	private void initGridView() {
		context=getActivity();
		Bundle bundle=getArguments();
		index=bundle.getInt("index");
		sex=bundle.getBoolean("sex");
		gridView=(GridView) view.findViewById(R.id.gridView);
		getData();
		GridAdapter gridAdapter=new GridAdapter(resIds, context);
		gridView.setAdapter(gridAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				idcListener.onchanged(index, resIds.get(position));
			}
		});
	}
	/**
	 * 根据当前滑动得到当前position，获取当前数据源
	 */
	private void getData() {
		switch (index) {
		case 0://发型
			if(sex){
				ids=MyRes.getRealBoyHair();
			}else {
				ids=MyRes.getRealGirlHair();
			}
			break;
		case 1://脸型
			ids=MyRes.getFaceShape();
			break;
		case 2://眉毛
				ids=MyRes.getEyeBrow();
			break;
		case 3://眼睛
			ids=MyRes.getEye();
			break;
		case 4://嘴巴
			ids=MyRes.getMouth();
			break;
		case 5://特征
			if(sex){
				ids=MyRes.getRealBoyFeature();
			}else {
				ids=MyRes.getRealGirlFeature();
			}
			break;
		case 6://眼镜
			ids=MyRes.getGlass();
			break;
		case 7://衣服
			if(sex){
				ids=MyRes.getBoyClothes();
			}else {
				ids=MyRes.getGirlClothes();
			}
			break;
		case 8://帽子
				ids=MyRes.getHat();
			break;
		case 9://爱好
			ids=MyRes.getHobby();
			break;
		case 10://背景
			ids=MyRes.getBackGround();
			break;
		case 11://气泡
			ids=MyRes.getPop();
			break;
			
		default:
			break;
		}
		
		for (int i = 0; i < ids.length; i++) {
			resIds.add(ids[i]);
		}
		
	}
	
	public void setChangedListener(IDecorationChangedListener idcListener){
		this.idcListener=idcListener;
	}
	
}
