package mvpframework.bwie.com.jingdonggwcdemo.net;

/**
 * Created by 何永武 on 2017/11/15.
 */

public interface OnNetListener<T> {
    public void OnSuccess(T t);
    public void OnFailour(Exception e);
}
