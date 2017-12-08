package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.GwcBean;
import mvpframework.bwie.com.jingdonggwcdemo.model.Imodel.IMainModel;
import mvpframework.bwie.com.jingdonggwcdemo.model.MainModel;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;
import mvpframework.bwie.com.jingdonggwcdemo.view2.IThreeFragment;


public class Mainpresenter {
    private  final IThreeFragment iMainActivity;
    private final IMainModel imainModel;

    public Mainpresenter(IThreeFragment iMainActivity) {
        this.iMainActivity = iMainActivity;
        imainModel = new MainModel();
    }
    public void getGwc(){
        imainModel.getGwc(new OnNetListener<GwcBean>() {

            @Override
            public void OnSuccess(GwcBean gwcBean) {
                List<GwcBean.DataBean> dataBeen = gwcBean.getData();
                ArrayList<List<GwcBean.DataBean.DatasBean>> childList = new ArrayList<>();
                for(int i = 0 ; i<dataBeen.size() ; i++){
                    List<GwcBean.DataBean.DatasBean> datas = dataBeen.get(i).getDatas();
                    childList.add(datas);
                }
                iMainActivity.showList(dataBeen,childList);
            }

            @Override
            public void OnFailour(Exception e) {

            }
        });
    }
}
