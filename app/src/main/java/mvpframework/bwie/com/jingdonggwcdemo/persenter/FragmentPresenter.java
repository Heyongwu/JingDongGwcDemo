package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import mvpframework.bwie.com.jingdonggwcdemo.view.IMainActivity;

/**
 * Created by 何永武 on 2017/11/13.
 */

public class FragmentPresenter  {
    private IMainActivity iMainActivity;

    public FragmentPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;

    }
    public void xiaocaozuo(){
        iMainActivity.show();
    }
}
