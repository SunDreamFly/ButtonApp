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

public class SpeciaAdapter extends RecyclerView.Adapter {
    private ArrayList<HomeBean.DataDTO.TopicListDTO> list;
    private Context context;

    public SpeciaAdapter(ArrayList<HomeBean.DataDTO.TopicListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_sprvcyclect, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeHolder homeHolder= (HomeHolder) holder;
        homeHolder.tv.setText(list.get(position).getTitle());
        homeHolder.text.setText(list.get(position).getSubtitle());
        homeHolder.price.setText("￥"+list.get(position).getTopic_tag_id()+"元起");
        Glide.with(context).load(list.get(position).getScene_pic_url()).into(homeHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder{
        TextView tv;
        TextView text;
        TextView price;
        ImageView iv;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv_sp);
            text=itemView.findViewById(R.id.text_sp);
            price=itemView.findViewById(R.id.price_sp);
            iv=itemView.findViewById(R.id.iv_sp);

        }
    }
}
