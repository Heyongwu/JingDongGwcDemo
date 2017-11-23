package mvpframework.bwie.com.jingdonggwcdemo.model;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.LoginBean;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;

/**
 * Created by 何永武 on 2017/11/14.
 */

public interface ILoginModel {
    public void Login(String account, String pwd, OnNetListener<LoginBean> onNetListener);
}
