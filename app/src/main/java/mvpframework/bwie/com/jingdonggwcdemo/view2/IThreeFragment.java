package mvpframework.bwie.com.jingdonggwcdemo.view2;

import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.GwcBean;

/**
 * Created by Yw_Ambition on 2017/12/7.
 */

public interface IThreeFragment {
    void showList(List<GwcBean.DataBean> groupList, List<List<GwcBean.DataBean.DatasBean>> childList);

}
