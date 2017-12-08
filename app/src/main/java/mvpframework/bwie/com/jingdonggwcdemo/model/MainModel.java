package mvpframework.bwie.com.jingdonggwcdemo.model;


import com.google.gson.Gson;

import java.io.IOException;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.GwcBean;
import mvpframework.bwie.com.jingdonggwcdemo.model.Imodel.IMainModel;
import mvpframework.bwie.com.jingdonggwcdemo.net.Api;
import mvpframework.bwie.com.jingdonggwcdemo.net.HttpUtils;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainModel extends BeanModel implements IMainModel {


    @Override
    public void getGwc(final OnNetListener<GwcBean> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.url, new Callback() {
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
                final GwcBean gwcBean = new Gson().fromJson(string, GwcBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnSuccess(gwcBean);
                    }
                });
            }
        });
    }
}
