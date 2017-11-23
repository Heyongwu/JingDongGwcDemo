package mvpframework.bwie.com.jingdonggwcdemo.view2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter.MyRecyclerAdapter;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
import mvpframework.bwie.com.jingdonggwcdemo.R;
import mvpframework.bwie.com.jingdonggwcdemo.persenter.TwoPresenter;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class TwoFragment extends Fragment implements ITwoFragment {
    private View view;
    private RecyclerView mRlvSmall;
    private RecyclerView mRlvBig;
//    private List<JdBean.DataBean> list = new ArrayList<>();

    private TwoPresenter twoPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.twofragment, container, false);
        initView(view);
        twoPresenter = new TwoPresenter(TwoFragment.this);
        twoPresenter.getZouQi();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);

        mRlvSmall.setLayoutManager(linearLayoutManager);//设置布局管理器，第三个参数为是否逆向布局
//        mRlvSmall.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }
    private void initView(View view) {
        mRlvSmall = (RecyclerView) view.findViewById(R.id.rlv_small);
        mRlvBig = (RecyclerView) view.findViewById(R.id.rlv_big);
    }

    @Override
    public void showData(List<JdBean.DataBean> list) {
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list, getActivity());
        mRlvSmall.setAdapter(adapter);
    }
}
