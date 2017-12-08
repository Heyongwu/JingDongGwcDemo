package mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import mvpframework.bwie.com.jingdonggwcdemo.JavaBean.ErJiBean;
import mvpframework.bwie.com.jingdonggwcdemo.R;

/**
 * Created by Yw_Ambition on 2017/12/4.
 */

class ErjiRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ErJiBean.DataBean.ListBean> listBean;
    private List<ErJiBean.DataBean> list2;
    private Context context;

    public ErjiRecyclerAdapter(List<ErJiBean.DataBean.ListBean> listBean, Context context) {
        this.listBean = listBean;
        this.context = context;

    }
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener {
        public void onItemClick(ErJiBean.DataBean.ListBean listBean);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.itemerji_you_zuixiaodeerjitupbuju,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ErJiBean.DataBean.ListBean listBean = this.listBean.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.xiao_tv.setText(listBean.getName());
        myViewHolder.sim.setImageURI(Uri.parse(listBean.getIcon()));
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(listBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBean.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sim;
        private final TextView xiao_tv;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            sim = itemView.findViewById(R.id.itemyou_iv_sim_xiao);
            xiao_tv = itemView.findViewById(R.id.item_you_tv_xiao);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
