package mvpframework.bwie.com.jingdonggwcdemo.model;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.ErJiBean;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;

/**
 * Created by 何永武 on 2017/11/15.
 */

public interface ITwoModel {
    public void getJdbean(OnNetListener<JdBean> onNetListener);
    public void getErjiBean(OnNetListener<ErJiBean> onNetListener);
}
