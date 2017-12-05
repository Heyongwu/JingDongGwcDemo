package mvpframework.bwie.com.jingdonggwcdemo.JavaBean;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Yw_Ambition on 2017/12/4.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
