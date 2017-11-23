package mvpframework.bwie.com.jingdonggwcdemo.persenter;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.LoginBean;
import mvpframework.bwie.com.jingdonggwcdemo.model.ILoginModel;
import mvpframework.bwie.com.jingdonggwcdemo.model.LoginModel;
import mvpframework.bwie.com.jingdonggwcdemo.net.OnNetListener;
import mvpframework.bwie.com.jingdonggwcdemo.view.IloginActivity;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class LoginPresenter {
    private IloginActivity iloginActivity;
    private final ILoginModel iloginModel;

    public LoginPresenter(IloginActivity iloginActivity) {
        this.iloginActivity = iloginActivity;
        iloginModel = new LoginModel();
    }
    public void getLogin(){
        String account = iloginActivity.getAccount();
        String pwd = iloginActivity.getPwd();
        iloginModel.Login(account, pwd, new OnNetListener<LoginBean>() {
            @Override
            public void OnSuccess(LoginBean loginBean) {
                iloginActivity.show(loginBean.getMsg());
                if(loginBean.getCode().equals("0")){
                    iloginActivity.ToSend();
                }
            }

            @Override
            public void OnFailour(Exception e) {

            }
        });
    }
//    public void
    public void Toregister(){
        iloginActivity.ToRegister();
    }
}
