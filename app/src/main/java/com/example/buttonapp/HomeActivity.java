package com.example.buttonapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buttonapp.fragment.ByteFragment;
import com.example.buttonapp.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    private FrameLayout frame;
    private RadioGroup rg;
    private RadioButton vHomePage;
    private RadioButton vSubject;
    private RadioButton vClassify;
    private RadioButton vShopping;
    private RadioButton vManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {

        frame = (FrameLayout) findViewById(R.id.frame);
        rg = (RadioGroup) findViewById(R.id.rg);
        vHomePage = (RadioButton) findViewById(R.id.v_homePage);
        vSubject = (RadioButton) findViewById(R.id.v_subject);
        vClassify = (RadioButton) findViewById(R.id.v_classify);
        vShopping = (RadioButton) findViewById(R.id.v_shopping);
        vManager = (RadioButton) findViewById(R.id.v_manager);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame,new HomeFragment())
                .commit();

    }

    public void initDrawable(RadioButton v) {
        Drawable drawable = v.getCompoundDrawables()[1];
//        drawable.setBounds(0,0, DensityUtil.dip2px(this,30),DensityUtil.dip2px(this,30));
        v.setCompoundDrawables(null, drawable, null, null);
    }
}