package com.example.buttonapp.contract;

import com.example.buttonapp.base.BaseModel;
import com.example.buttonapp.base.BaseView;
import com.example.buttonapp.bean.HomeBean;
import com.example.buttonapp.utils.net.NetCallBack;

public class MyContract {
    public interface InModel extends BaseModel {
        <B> void getLoginData(String url, NetCallBack<B> callback);
    }

    public interface InPresenter{
        void getData();
    }

    public interface InView extends BaseView {
        void getData(HomeBean bean);
    }
}
