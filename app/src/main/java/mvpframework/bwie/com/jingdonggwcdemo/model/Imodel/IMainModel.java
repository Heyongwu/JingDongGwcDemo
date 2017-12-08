package mvpframework.bwie.com.jingdonggwcdemo.model.Imodel;


import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.GwcBean;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;

public interface IMainModel {
    public void getGwc(OnNetListener<GwcBean> onNetListener);
}
