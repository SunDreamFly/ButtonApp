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
import com.bumptech.glide.Glide;
import com.example.buttonapp.R;
import com.example.buttonapp.bean.HomeBean;

import java.util.ArrayList;

public class SnacksAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> list;
    private GridLayoutHelper singleLayoutHelper;
    private Context context;

    public SnacksAdapter(ArrayList<HomeBean.DataDTO.NewGoodsListDTO> list, GridLayoutHelper singleLayoutHelper, Context context) {
        this.list = list;
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snacks, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeHolder holder1 = (HomeHolder) holder;
        holder1.tv.setText(list.get(position).getName());
        holder1.text.setText(list.get(position).getRetail_price());

        Glide.with(context).load(list.get(position).getList_pic_url()).into(holder1.iv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class HomeHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        TextView text;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_snacks);
            tv = itemView.findViewById(R.id.tv_snacks);
            text = itemView.findViewById(R.id.text_snacks);
        }
    }
}
