package com.example.buttonapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buttonapp.R;
import com.youth.banner.Banner;

/**
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        Banner banner = view.findViewById(R.id.banner);
        RecyclerView lan = view.findViewById(R.id.rv_lan);
        RecyclerView rvck = view.findViewById(R.id.rv_Ck);
        RecyclerView food = view.findViewById(R.id.rv_food);
    }
}