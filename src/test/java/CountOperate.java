/**
 * Created by ouyangyaoxu on 2018/3/30.
 * Desc:
 */
public class CountOperate extends Thread {
    private static final String TAG = "DemoThread";

    public CountOperate(){
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());//获取线程名
        System.out.println("this.getName=" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("this.getName()=" + this.getName());
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());//获取线程名
    }
}
