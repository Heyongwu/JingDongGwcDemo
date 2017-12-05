package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.ErJiBean;
import mvpframework.bwie.com.jingdonggwcdemo.model.ITwoModel;
import mvpframework.bwie.com.jingdonggwcdemo.model.TwoModel;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;
import mvpframework.bwie.com.jingdonggwcdemo.view2.ITwoFragment;

/**
 * Created by Yw_Ambition on 2017/12/4.
 */

public class Twopresent {
    private  static ITwoFragment iTwoFragment;
    private final ITwoModel itwoModel;

    public Twopresent(ITwoFragment iTwoFragment) {
        this.iTwoFragment = iTwoFragment;
        itwoModel = new TwoModel();
    }
    public void getpp() {
        itwoModel.getErjiBean(new OnNetListener<ErJiBean>() {
            @Override
            public void OnSuccess(ErJiBean erJiBean) {
//                List<ErJiBean.DataBean> data = ;
                iTwoFragment.showErji(erJiBean.getData());
            }
            @Override
            public void OnFailour(Exception e) {

            }
        });
    }
}
