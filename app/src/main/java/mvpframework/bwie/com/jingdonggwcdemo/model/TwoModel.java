package mvpframework.bwie.com.jingdonggwcdemo.model;

import com.google.gson.Gson;

import java.io.IOException;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.BeasModel;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.ErJiBean;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
import mvpframework.bwie.com.jingdonggwcdemo.net.Api;
import mvpframework.bwie.com.jingdonggwcdemo.net.HttpUtils;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 何永武 on 2017/11/15.
 */

public class TwoModel extends BeasModel implements ITwoModel {
    @Override
    public void getJdbean(final OnNetListener<JdBean> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.PRODUCT, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnFailour(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final JdBean dataBean = new Gson().fromJson(string, JdBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnSuccess(dataBean);
                    }
                });

            }
        });
    }

    @Override
    public void getErjiBean(String cid, final OnNetListener<ErJiBean> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.PRODUCTCATAGORY, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnFailour(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final ErJiBean productCatagoryBean = new Gson().fromJson(string, ErJiBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnSuccess(productCatagoryBean);
                    }
                });
            }
        });
    }





}
