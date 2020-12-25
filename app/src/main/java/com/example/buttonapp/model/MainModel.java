package com.example.buttonapp.model;

import com.example.buttonapp.contract.MyContract;
import com.example.buttonapp.utils.net.NetCallBack;
import com.example.buttonapp.utils.net.RetrofitUtils;

public class MainModel implements MyContract.InModel {
    @Override
    public <B> void getLoginData(String url, NetCallBack<B> callback) {
        RetrofitUtils.getRetrofitUtils().get(url, callback);
    }
}