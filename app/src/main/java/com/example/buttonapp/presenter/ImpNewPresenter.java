package com.example.buttonapp.presenter;

import com.example.buttonapp.base.BasePresenter;
import com.example.buttonapp.bean.HomeBean;
import com.example.buttonapp.contract.MyContract;
import com.example.buttonapp.model.ImpModel;
import com.example.buttonapp.utils.net.NetCallBack;

public class ImpNewPresenter extends BasePresenter<MyContract.InModel<HomeBean>,MyContract.InView> implements MyContract.InPresenter {
    public ImpNewPresenter(MyContract.InView view) {
        super(view);
    }

    @Override
    protected MyContract.InModel<HomeBean> getModel() {
        return new ImpModel<HomeBean>();
    }

    @Override
    public void getData(String url) {
        model.getData(url, new NetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                view.onSuccess(homeBean);
            }

            @Override
            public void onFail(String error) {
                view.onFail(error);
            }
        });
    }
}
