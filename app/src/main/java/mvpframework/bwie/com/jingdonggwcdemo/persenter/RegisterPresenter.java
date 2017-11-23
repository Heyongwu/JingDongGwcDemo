package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.LoginBean;
import mvpframework.bwie.com.jingdonggwcdemo.model.IRegisterModel;
import mvpframework.bwie.com.jingdonggwcdemo.model.RegisterModel;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;
import mvpframework.bwie.com.jingdonggwcdemo.view.IRegisterActivity;

/**
 * Created by 何永武 on 2017/11/15.
 */

public class RegisterPresenter {
    private static IRegisterActivity iRegisterActivity;
    private final IRegisterModel iregisterModel;

    public RegisterPresenter(IRegisterActivity iRegisterActivity) {
        this.iRegisterActivity = iRegisterActivity;
        iregisterModel = new RegisterModel();
    }
    public void register(){
        String account = iRegisterActivity.getAccount();
        String pwd = iRegisterActivity.getPwd();
        iregisterModel.register(account, pwd, new OnNetListener<LoginBean>() {
            @Override
            public void OnSuccess(LoginBean loginBean) {
                iRegisterActivity.show(loginBean.getMsg());
                iRegisterActivity.ToLogin();
            }

            @Override
            public void OnFailour(Exception e) {

            }
        });
    }
}
