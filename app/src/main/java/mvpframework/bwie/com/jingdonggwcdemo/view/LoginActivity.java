package mvpframework.bwie.com.jingdonggwcdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import mvpframework.bwie.com.jingdonggwcdemo.R;
import mvpframework.bwie.com.jingdonggwcdemo.persenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements IloginActivity, View.OnClickListener {

    /**
     * 请输入账号
     */
    private EditText mLgEt1;
    /**
     * 请输入密码
     */
    private EditText mLgEt2;
    /**
     * 登录
     */
    private Button mLgBt;
    /**
     * 快速注册
     */
    private TextView mTvRegister;
    /**
     * QQ快捷登录
     */
    private TextView mTvQQ;
    private LinearLayout mActivityLogin;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        presenter = new LoginPresenter(this);

    }

    private void initView() {
        mLgEt1 = (EditText) findViewById(R.id.lg_et1);
        mLgEt2 = (EditText) findViewById(R.id.lg_et2);
        mLgBt = (Button) findViewById(R.id.lg_bt);
        mLgBt.setOnClickListener(this);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        mTvRegister.setOnClickListener(this);
        mTvQQ = (TextView) findViewById(R.id.tv_QQ);
        mTvQQ.setOnClickListener(this);
        mActivityLogin = (LinearLayout) findViewById(R.id.activity_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.lg_bt:
                presenter.getLogin();
                break;
            case R.id.tv_register:
                presenter.Toregister();
                break;
            case R.id.tv_QQ:

                break;
        }
    }

    @Override
    public String getAccount() {
        return mLgEt1.getText().toString();
    }

    @Override
    public String getPwd() {
        return mLgEt2.getText().toString();
    }

    @Override
    public void show(String str) {
        Toast.makeText(LoginActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void ToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void ToSend() {

        Intent intent = new Intent();
        intent.setClass(LoginActivity.this,MainActivity.class);
        intent.putExtra("fragid",4);
       startActivity(intent);
    }
}
