package com.example.buttonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buttonapp.R;
import com.example.buttonapp.bean.HomeBean;

import java.util.ArrayList;

public class LivingRvAdapter extends RecyclerView.Adapter {
    private ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> list;
    private Context context;

    public LivingRvAdapter(ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_livingrv, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeHolder homeHolder= (HomeHolder) holder;
        homeHolder.tv.setText(list.get(position).getName());
        homeHolder.text.setText("￥"+list.get(position).getRetail_price());
        Glide.with(context).load(list.get(position).getList_pic_url()).into(homeHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder{
        TextView tv;
        TextView text;
        ImageView iv;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
             tv = itemView.findViewById(R.id.tv_rv);
             text = itemView.findViewById(R.id.text_rv);
             iv = itemView.findViewById(R.id.iv_rv);
        }
    }
}
