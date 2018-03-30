/**
 * Created by ouyangyaoxu on 2018/3/30.
 * Desc:
 */
public class Test {
    private static final String TAG = "Test";

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        t1.setName("A");
        t1.start();
    }
}
