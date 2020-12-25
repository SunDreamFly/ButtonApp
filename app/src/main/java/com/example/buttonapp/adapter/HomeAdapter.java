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

public class HomeAdapter extends DelegateAdapter.Adapter {

    private  ArrayList<HomeBean.DataDTO.ChannelDTO> list;
    private GridLayoutHelper singleLayoutHelper;
    private Context context;

    public HomeAdapter(ArrayList<HomeBean.DataDTO.ChannelDTO> list, GridLayoutHelper singleLayoutHelper, Context context) {
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
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ho, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeHolder homeHolder= (HomeHolder) holder;
        homeHolder.tv.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon_url()).into(homeHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
             tv = itemView.findViewById(R.id.tv);
             iv = itemView.findViewById(R.id.iv);
        }
    }
}
