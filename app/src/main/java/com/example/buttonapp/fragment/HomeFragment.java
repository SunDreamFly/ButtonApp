package com.example.buttonapp.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.buttonapp.R;
import com.example.buttonapp.adapter.BannerAdapter;
import com.example.buttonapp.base.BaseFragment;
import com.example.buttonapp.bean.HomeBean;
import com.example.buttonapp.contract.MyContract;
import com.example.buttonapp.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class HomeFragment extends BaseFragment<MainPresenter> implements MyContract.InView {


    private RecyclerView rcy;
    private ArrayList<HomeBean.DataDTO.BannerDTO> imgs;
    private BannerAdapter singleAdapter;
    private DelegateAdapter adapter;

    @Override
    protected void initView(View view) {
        rcy = view.findViewById(R.id.rcy);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找

        rcy.setLayoutManager(virtualLayoutManager);

        // 将VirtualLayoutManager绑定到recyclerView
        //设置回收复用池大小
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        rcy.setLayoutManager(virtualLayoutManager);
        /**
         设置通栏布局
         banner
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        imgs = new ArrayList<>();
        singleAdapter = new BannerAdapter(imgs,singleLayoutHelper);


        adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(singleAdapter);
        rcy.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void getData(HomeBean bean) {
        List<HomeBean.DataDTO.BannerDTO> banner = bean.getData().getBanner();
        imgs.addAll(banner);
        singleAdapter.notifyDataSetChanged();

    }
}