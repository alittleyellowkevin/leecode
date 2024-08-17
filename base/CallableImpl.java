package base;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "我是第三种方法：线程启动";
    }
}
