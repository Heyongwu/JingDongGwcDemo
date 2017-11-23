package mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.JdBean;
import mvpframework.bwie.com.jingdonggwcdemo.R;

/**
 * Created by 何永武 on 2017/11/15.
 */


public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JdBean.DataBean> list;
    private Context context;

    public MyRecyclerAdapter(List<JdBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(context).inflate(R.layout.item_small,parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        JdBean.DataBean jdBean = list.get(position);

        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        ((MyViewHolder) holder).tv_small.setText(jdBean.getName());

//        ((MyViewHolder) holder).tv_small.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                JdBean.DataBean dataBean = list.get(position);
//
//                Toast.makeText(context,"哈哈哈",Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_small;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_small = (TextView) itemView.findViewById(R.id.tv_small);
        }
    }
     
}
