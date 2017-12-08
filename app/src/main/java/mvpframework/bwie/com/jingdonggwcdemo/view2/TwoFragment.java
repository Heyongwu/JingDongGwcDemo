package mvpframework.bwie.com.jingdonggwcdemo.view2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter.LeftAdapter;
import mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter.MyErjiAdapter;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.ErJiBean;
import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
import mvpframework.bwie.com.jingdonggwcdemo.R;
import mvpframework.bwie.com.jingdonggwcdemo.net.GlideImageLoader;
import mvpframework.bwie.com.jingdonggwcdemo.persenter.Twopresent;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class TwoFragment extends Fragment implements ITwoFragment {

    private View view;
    private ListView mRlvSmall;
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<ErJiBean.DataBean.ListBean>> childList = new ArrayList<>();//二级列表数据
    private List<ErJiBean> group = new ArrayList<>();
    private ExpandableListView elv;
    private ErJiBean.DataBean dataBean;
    private LeftAdapter adapter;
    private Banner itemYouBanner;

    //    private List<JdBean.DataBean> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.twofragment, container, false);
        initView(view);
//        twoPresent2 = new TwoPresent2(this);
//        twoPresent2.getShow();
        final Twopresent twopresent = new Twopresent(this);
        twopresent.getProductCatagory();


        mRlvSmall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.press(position);
                //请求对应的右侧数据
                //先获取cid
                JdBean.DataBean dataBean = (JdBean.DataBean) parent.getItemAtPosition(position);
                int cid = dataBean.getCid();
                twopresent.getpp(cid + "");
            }
        });
//        mRlvSmall.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        Lunbo();
        return view;
    }

    private void Lunbo() {
        String icon = "https://www.zhaoapi.cn/images/quarter/ad2.png";
        String icon1 = "https://www.zhaoapi.cn/images/quarter/ad3.png";
        String icon2 = "https://www.zhaoapi.cn/images/quarter/ad4.png";
        //轮播
        itemYouBanner.setImageLoader(new GlideImageLoader());
        List<String> list = new ArrayList<>();
        list.add(icon);
        list.add(icon1);
        list.add(icon2);
        itemYouBanner.setImages(list);
        itemYouBanner.start();
    }

    //               adapter.press(position);
//    //请求对应的右侧数据
//    //先获取cid
//    JdBean.DataBean dataBean = (JdBean.DataBean) parent.getItemAtPosition(position);
//    int cid = dataBean.getCid();
//                twopresent.getpp(cid + "");
    private void initView(View view) {
        mRlvSmall = (ListView) view.findViewById(R.id.rlv_small);
        elv = view.findViewById(R.id.elv);
        itemYouBanner = view.findViewById(R.id.item_you_banner);
    }
    @Override
    public void showData(List<JdBean.DataBean> list) {
        adapter = new LeftAdapter(getActivity(), list);
        mRlvSmall.setAdapter(adapter);
    }
    @Override
    public void showErji(List<ErJiBean.DataBean> lists) {
        //给二级列表封住数据
        for (int i = 0; i < lists.size(); i++) {
            dataBean = lists.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
        }
        MyErjiAdapter myErjiAdapter = new MyErjiAdapter(getActivity(), groupList, childList);
        elv.setAdapter(myErjiAdapter);
        //设置默认全部展开
        for (int i = 0; i < lists.size(); i++) {
            elv.expandGroup(i);
        }
    }

}
