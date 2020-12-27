package com.example.buttonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.buttonapp.R;
import com.example.buttonapp.bean.HomeBean;

import java.util.ArrayList;

public class BeddingAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> list;
    private Context context;
    private GridLayoutHelper ColumnLayoutHelper;

    public BeddingAdapter(ArrayList<HomeBean.DataDTO.HotGoodsListDTO> list, Context context, GridLayoutHelper columnLayoutHelper) {
        this.list = list;
        this.context = context;
        ColumnLayoutHelper = columnLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return ColumnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_bedding, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeHolder homeHolder= (HomeHolder) holder;
        homeHolder.tv.setText(list.get(position).getName());
        homeHolder.text.setText(list.get(position).getGoods_brief());
        homeHolder.price.setText("￥"+list.get(position).getRetail_price()+"");
        Glide.with(context).load(list.get(position).getList_pic_url()).into(homeHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        TextView text;
        TextView price;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_bedding);
            tv = itemView.findViewById(R.id.tv_bedding);
            text = itemView.findViewById(R.id.text_deeding);
            price = itemView.findViewById(R.id.price_bedding);
        }
    }
}
