package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import mvpframework.bwie.com.jingdonggwcdemo.model.ITwoModel;
import mvpframework.bwie.com.jingdonggwcdemo.model.TwoModel;
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

    }
}
