package mvpframework.bwie.com.jingdonggwcdemo.view2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter.MyErjiAdapter;
import mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter.MyRecyclerAdapter;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.ErJiBean;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
import mvpframework.bwie.com.jingdonggwcdemo.R;
import mvpframework.bwie.com.jingdonggwcdemo.persenter.TwoPresent2;
import mvpframework.bwie.com.jingdonggwcdemo.persenter.Twopresent;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class TwoFragment extends Fragment implements ITwoFragment {
    @BindView(R.id.elv)
    ExpandableListView elv;
    Unbinder unbinder;
    private View view;
    private RecyclerView mRlvSmall;
    private TwoPresent2 twoPresent2;
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<ErJiBean.DataBean.ListBean>> childList = new ArrayList<>();//二级列表数据
//    private List<JdBean.DataBean> list = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.twofragment, container, false);
        initView(view);
        twoPresent2 = new TwoPresent2(this);
        twoPresent2.getShow();
        Twopresent twopresent = new Twopresent(this);
        twopresent.getpp();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);

        mRlvSmall.setLayoutManager(linearLayoutManager);//设置布局管理器，第三个参数为是否逆向布局
//        mRlvSmall.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void initView(View view) {
        mRlvSmall = (RecyclerView) view.findViewById(R.id.rlv_small);
    }
    @Override
    public void showData(List<JdBean.DataBean> list) {
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list, getActivity());
        mRlvSmall.setAdapter(adapter);
    }
    @Override
    public void showErji(List<ErJiBean.DataBean> lists) {
        //给二级列表封住数据
        for (int i = 0; i < lists.size(); i++) {
            ErJiBean.DataBean dataBean = lists.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
        }
        MyErjiAdapter myErjiAdapter = new MyErjiAdapter(getActivity(),groupList,childList);
        elv.setAdapter(myErjiAdapter);
        //设置默认全部展开
        for (int i = 0; i < lists.size(); i++) {
            elv.expandGroup(i);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
