package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
import mvpframework.bwie.com.jingdonggwcdemo.model.ITwoModel;
import mvpframework.bwie.com.jingdonggwcdemo.model.TwoModel;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;
import mvpframework.bwie.com.jingdonggwcdemo.view2.ITwoFragment;

/**
 * Created by Yw_Ambition on 2017/12/4.
 */

public class TwoPresent2 {
    private  static ITwoFragment iTwoFragment;
    private final ITwoModel itwoModel;

    public TwoPresent2(ITwoFragment iTwoFragment) {
        this.iTwoFragment = iTwoFragment;
        itwoModel = new TwoModel();
    }
    public void getShow(){
        itwoModel.getJdbean(new OnNetListener<JdBean>() {
            @Override
            public void OnSuccess(JdBean jdBean) {
                List<JdBean.DataBean> data = jdBean.getData();
                iTwoFragment.showData(data);
            }

            @Override
            public void OnFailour(Exception e) {

            }
        });

    }
}
