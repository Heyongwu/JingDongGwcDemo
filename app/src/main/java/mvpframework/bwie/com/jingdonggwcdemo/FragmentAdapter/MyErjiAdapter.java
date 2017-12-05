package mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.ErJiBean;
import mvpframework.bwie.com.jingdonggwcdemo.R;
import mvpframework.bwie.com.jingdonggwcdemo.view.JiaRuGouWuActivity;

/**
 * Created by Yw_Ambition on 2017/12/4.
 */

public class MyErjiAdapter extends BaseExpandableListAdapter{
    private List<String> groupList;//一级列表数据
    private List<List<ErJiBean.DataBean.ListBean>> childList;//二级列表数据
    private LayoutInflater inflater;
    private Context context;

    public MyErjiAdapter(Context context, List<String> groupList, List<List<ErJiBean.DataBean.ListBean>> childList) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childList.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childList.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        MyGroupViewHolder myGroupViewHolder;
        View view1;
        if(view == null){
            myGroupViewHolder = new MyGroupViewHolder();
            view1 = inflater.inflate(R.layout.item_you_tv_shang,null);
            myGroupViewHolder.tv_shang = view1.findViewById(R.id.tv_shang);
            view1.setTag(myGroupViewHolder);
        }else {
            view1 = view;
            myGroupViewHolder = (MyGroupViewHolder) view1.getTag();
        }

        myGroupViewHolder.tv_shang.setText(groupList.get(i));

        return view1;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        MyChildViewHolder myChildViewHolder;
        View view1;
        if(view == null){
            myChildViewHolder = new MyChildViewHolder();
            view1 = inflater.inflate(R.layout.twoyouitem,null);
            myChildViewHolder.item_you_rlv = view1.findViewById(R.id.item_you_rlv);
            view1.setTag(myChildViewHolder);
        }else{
            view1 = view;
            myChildViewHolder = new MyChildViewHolder();
        }
        List<ErJiBean.DataBean.ListBean> listBeans = childList.get(i);
        myChildViewHolder.item_you_rlv.setLayoutManager(new GridLayoutManager(context,3));
        ErjiRecyclerAdapter adapter = new ErjiRecyclerAdapter(listBeans,context);
        myChildViewHolder.item_you_rlv.setAdapter(adapter);
        adapter.setOnItemClickListener(new ErjiRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ErJiBean.DataBean.ListBean listBean) {
                Intent intent = new Intent(context, JiaRuGouWuActivity.class);
                intent.putExtra("pscid",listBean.getPscid());
                context.startActivity(intent);
            }
        });
        return view1;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    class MyGroupViewHolder{
        TextView tv_shang;

    }
    class MyChildViewHolder{
        RecyclerView item_you_rlv;
    }
}
