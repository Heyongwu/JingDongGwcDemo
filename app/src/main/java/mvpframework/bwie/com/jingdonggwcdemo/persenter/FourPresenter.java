package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import mvpframework.bwie.com.jingdonggwcdemo.view2.FourFragment;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class FourPresenter {
    private FourFragment fourFragment;

    public FourPresenter(FourFragment fourFragment) {
        this.fourFragment = fourFragment;

    }
    public void getTz(){
        fourFragment.DianJ();
    }
}
