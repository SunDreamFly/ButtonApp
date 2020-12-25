package com.example.buttonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.buttonapp.fragment.ByteFragment;
import com.example.buttonapp.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fl;
    private RadioGroup rg;
    private RadioButton bt;
    private RadioButton bt2;
    private RadioButton bt3;
    private RadioButton bt4;
    private RadioButton bt5;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private ByteFragment byteFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl = findViewById(R.id.fl);
        rg = findViewById(R.id.rg);
        bt = findViewById(R.id.bt);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        transaction = getSupportFragmentManager().beginTransaction();
        homeFragment = new HomeFragment();
        byteFragment = new ByteFragment();
        transaction.add(R.id.fl, homeFragment)
                .add(R.id.fl, byteFragment)
                .hide(homeFragment)
                .hide(byteFragment)
                .commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt:
                        getSupportFragmentManager().beginTransaction()
                                .show(homeFragment)
                                .hide(byteFragment)
                                .commit();
                        break;
                    case R.id.bt2:
                        getSupportFragmentManager().beginTransaction()
                                .hide(byteFragment)
                                .show(homeFragment)
                                .commit();
                        break;
                    case R.id.bt3:
                      /*  getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .hide(subjectFragment)
                                .show(classifyFragment)
                                .hide(shopFragment)
                                .hide(myFragment)
                                .commit();*/
                        break;
                    case R.id.bt4:
                       /* getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .hide(subjectFragment)
                                .hide(classifyFragment)
                                .show(shopFragment)
                                .hide(myFragment)
                                .commit();*/
                        break;
                    case R.id.bt5:
                        /*getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .hide(subjectFragment)
                                .hide(classifyFragment)
                                .hide(shopFragment)
                                .show(myFragment)
                                .commit();*/
                        break;
                }
            }
        });
    }
}
