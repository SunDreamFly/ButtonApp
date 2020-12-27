package com.example.buttonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.buttonapp.R;
import com.example.buttonapp.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class LivingAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> list;
    private Context context;
    private SingleLayoutHelper gridLayoutHelper;

    public LivingAdapter(ArrayList<HomeBean.DataDTO.CategoryListDTO> list, Context context, SingleLayoutHelper gridLayoutHelper) {
        this.list = list;
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_livinga, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeHolder homeHolder= (HomeHolder) holder;
        HomeBean.DataDTO.CategoryListDTO categoryListDTO = list.get(position);
        homeHolder.tv.setText(list.get(position).getName());

        homeHolder.rv.setLayoutManager(new GridLayoutManager(context,2));
        ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = (ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO>) categoryListDTO.getGoodsList();
        LivingRvAdapter livingRvAdapter = new LivingRvAdapter(goodsList, context);
        homeHolder.rv.setAdapter(livingRvAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder{
        TextView tv;
        RecyclerView rv;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
             tv = itemView.findViewById(R.id.tv_living);
             rv = itemView.findViewById(R.id.rv_living);
        }
    }
}
