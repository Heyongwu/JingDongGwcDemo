package mvpframework.bwie.com.jingdonggwcdemo.view2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvpframework.bwie.com.jingdonggwcdemo.R;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class ThreeFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.threefragment,container,false);
        return view;
    }
}
