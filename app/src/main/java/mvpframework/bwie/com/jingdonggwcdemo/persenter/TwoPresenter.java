package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
import mvpframework.bwie.com.jingdonggwcdemo.model.ITwoModel;
import mvpframework.bwie.com.jingdonggwcdemo.model.TwoModel;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;
import mvpframework.bwie.com.jingdonggwcdemo.view2.ITwoFragment;

/**
 * Created by 何永武 on 2017/11/15.
 */

public class TwoPresenter {
    private  static ITwoFragment iTwoFragment;
    private final ITwoModel itwoModel;

    public TwoPresenter(ITwoFragment iTwoFragment) {
        this.iTwoFragment = iTwoFragment;
        itwoModel = new TwoModel();
    }
    public void getZouQi(){
        itwoModel.getJdbean(new OnNetListener<JdBean>() {
            @Override
            public void OnSuccess(JdBean dataBean) {
                iTwoFragment.showData(dataBean.getData());
            }

            @Override
            public void OnFailour(Exception e) {

            }
        });
    }
}
