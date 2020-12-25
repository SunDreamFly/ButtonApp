package com.example.buttonapp.model;

import com.example.buttonapp.contract.MyContract;
import com.example.buttonapp.utils.net.NetCallBack;
import com.example.buttonapp.utils.net.RetrofitUtils;

public class ImpModel<T> implements MyContract.InModel<T> {
    @Override
    public void getData(String url, NetCallBack<T> callBack) {
        RetrofitUtils retrofitUtils = RetrofitUtils.getRetrofitUtils();
        retrofitUtils.get(url,callBack);
    }
}
