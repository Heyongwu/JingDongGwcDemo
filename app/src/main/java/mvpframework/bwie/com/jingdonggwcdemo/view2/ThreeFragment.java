package mvpframework.bwie.com.jingdonggwcdemo.view2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter.MyAdapter;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.GwcBean;
import mvpframework.bwie.com.jingdonggwcdemo.R;
import mvpframework.bwie.com.jingdonggwcdemo.net.EventBut;
import mvpframework.bwie.com.jingdonggwcdemo.net.PriceAndCountEvent;
import mvpframework.bwie.com.jingdonggwcdemo.persenter.Mainpresenter;


/**
 * Created by 何永武 on 2017/11/14.
 */

public class ThreeFragment extends Fragment implements IThreeFragment{

    private ExpandableListView mElv;
    private CheckBox mMainCb;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private MyAdapter adapter;
    private int totlcount =0;
    private int totlprice =0;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.threefragment,container,false);
        initView();
        Mainpresenter mainpresenter = new Mainpresenter(this);
        mainpresenter.getGwc();
        mMainCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.SelectAllGroupListChecked(mMainCb.isChecked());
            }
        });

        return view;
    }


        private void initView() {
            mElv = view.findViewById(R.id.elv);
            mMainCb = view.findViewById(R.id.main_cb);
            mTvPrice = view.findViewById(R.id.tv_price);
            mTvNum = view.findViewById(R.id.tv_num);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            EventBus.getDefault().unregister(this);
        }



    @Subscribe
        public void MessageEvent(EventBut event){
            mMainCb.setChecked(event.isChecked());

        }
        @Subscribe
        public void MessageEvent(PriceAndCountEvent event){
            totlcount += event.getCount();
            totlprice += event.getPrice();
            mTvNum.setText("结算(" + totlcount + ")");
            mTvPrice.setText(totlprice + "");
        }
    @Override
    public void showList(List<GwcBean.DataBean> groupList, List<List<GwcBean.DataBean.DatasBean>> childList) {
        adapter = new MyAdapter(groupList, childList, getActivity());
        mElv.setAdapter(adapter);
//        mElv.setGroupIndicator(null);
        //默认让其全部展开
        for (int i = 0; i < groupList.size(); i++) {
            mElv.expandGroup(i);
        }
    }
}
