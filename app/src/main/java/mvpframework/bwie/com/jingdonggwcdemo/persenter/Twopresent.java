package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.ErJiBean;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
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
    public void getpp(String cid) {

        itwoModel.getErjiBean(cid,new OnNetListener<ErJiBean>() {
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
    public void getProductCatagory(){
        itwoModel.getJdbean(new OnNetListener<JdBean>() {
            @Override
            public void OnSuccess(JdBean jdBean) {
                List<JdBean.DataBean> data = jdBean.getData();
                iTwoFragment.showData(data);
                int cid = data.get(0).getCid();
                getpp(cid+"");
            }

            @Override
            public void OnFailour(Exception e) {

            }
        });
    }


}
