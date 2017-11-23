package mvpframework.bwie.com.jingdonggwcdemo.view2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mvpframework.bwie.com.jingdonggwcdemo.R;
import mvpframework.bwie.com.jingdonggwcdemo.persenter.FourPresenter;
import mvpframework.bwie.com.jingdonggwcdemo.view.LoginActivity;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class FourFragment extends Fragment implements IFourFagment , View.OnClickListener {
    private View view;
    /**
     * 登录/注册>
     */
    private TextView mTvLgregister;
    private FourPresenter fourPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fourfragment, container, false);
        fourPresenter = new FourPresenter(this);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mTvLgregister = (TextView) view.findViewById(R.id.tv_lgregister);
        mTvLgregister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_lgregister:
                fourPresenter.getTz();
                break;
        }
    }

    @Override
    public void DianJ() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }


}
