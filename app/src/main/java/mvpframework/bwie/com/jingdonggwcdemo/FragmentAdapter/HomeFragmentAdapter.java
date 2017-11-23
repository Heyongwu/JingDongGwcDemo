package mvpframework.bwie.com.jingdonggwcdemo.FragmentAdapter;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 何永武 on 2017/11/14.
 */

public class HomeFragmentAdapter extends FragmentActivity {
    private List<Fragment> list = new ArrayList<>();
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;
    private int index;
    private Context context;
    public HomeFragmentAdapter(List<Fragment> list ,  Context context ,  ViewPager viewPager) {
        this.list = list;
        this.context = context;
        this.viewPager = viewPager;
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);



    }




//}
//
//    public HomeFragmentAdapter(FragmentManager fm, List<Fragment> list) {
//        super(fm);
//        this.list = list;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        return list.get(position);
//    }
}
