package com.example.buttonapp.presenter;

import com.example.buttonapp.base.BasePresenter;
import com.example.buttonapp.bean.HomeBean;
import com.example.buttonapp.contract.MyContract;
import com.example.buttonapp.model.MainModel;
import com.example.buttonapp.utils.net.NetCallBack;
import com.example.buttonapp.utils.net.URLConstant;

public class MainPresenter extends BasePresenter<MyContract.InView,MyContract.InModel> implements MyContract.InPresenter {
    @Override
    public MyContract.InModel getiModel() {
        return new MainModel();
    }

    @Override
    public void getData() {
        iModel.getLoginData(URLConstant.NEWSLIST, new NetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean bean) {
                iView.getData(bean);
            }

            @Override
            public void onFail(String string) {
//                iView.getData(string);
            }
        });
    }
}