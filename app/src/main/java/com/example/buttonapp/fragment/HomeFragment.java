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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.buttonapp.R;
import com.example.buttonapp.adapter.BannerAdapter;
import com.example.buttonapp.adapter.BrandAdapter;
import com.example.buttonapp.adapter.HomeAdapter;
import com.example.buttonapp.adapter.TextAdapter;
import com.example.buttonapp.base.BaseFragment;
import com.example.buttonapp.bean.HomeBean;
import com.example.buttonapp.contract.MyContract;
import com.example.buttonapp.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HomeFragment extends BaseFragment<MainPresenter> implements MyContract.InView {


    private RecyclerView rcy;
    private ArrayList<HomeBean.DataDTO.BannerDTO> imgs;
    private BannerAdapter singleAdapter;
    private DelegateAdapter adapter;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> channelDTOS;
    private HomeAdapter homeAdapter;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> brandListDTOS;
    private BrandAdapter brandAdapter;
    private TextAdapter textAdapter;

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
        getSingleLayoutHelper();
        getGridHelper();
        getText();
        getBrandHelper();


        adapter = new DelegateAdapter(virtualLayoutManager, false);
        adapter.addAdapter(singleAdapter);
        adapter.addAdapter(homeAdapter);
        adapter.addAdapter(textAdapter);
        adapter.addAdapter(brandAdapter);
        rcy.setAdapter(adapter);
    }

    private void getText() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // 同上面Weigths属性讲解
        textAdapter = new TextAdapter(getContext(), singleLayoutHelper);
    }

    private void getBrandHelper() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(2);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(1);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(0);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(0);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        brandListDTOS = new ArrayList<>();
        brandAdapter = new BrandAdapter(brandListDTOS, gridLayoutHelper, getContext());


    }

    private void getGridHelper() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格

        channelDTOS = new ArrayList<>();
        homeAdapter = new HomeAdapter(channelDTOS, gridLayoutHelper, getContext());
    }

    private SingleLayoutHelper getSingleLayoutHelper() {
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
        singleLayoutHelper.setAspectRatio(1);// 设置设置布局内每行布局的宽与高的比
        imgs = new ArrayList<>();
        singleAdapter = new BannerAdapter(imgs, singleLayoutHelper);
        return singleLayoutHelper;
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

        List<HomeBean.DataDTO.ChannelDTO> channel = bean.getData().getChannel();
        channelDTOS.addAll(channel);
        homeAdapter.notifyDataSetChanged();

        List<HomeBean.DataDTO.BrandListDTO> brandList = bean.getData().getBrandList();
        brandListDTOS.addAll(brandList);
        brandAdapter.notifyDataSetChanged();

    }
}