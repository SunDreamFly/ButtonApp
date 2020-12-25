package com.example.buttonapp.utils.net;

public interface NetCallBack<B> {
    void onSuccess(B b);

    void onFail(String error);
}
