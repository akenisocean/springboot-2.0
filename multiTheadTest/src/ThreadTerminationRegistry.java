import java.util.HashSet;
import java.util.Set;

/**
 * @author jack chao
 * @create 2019-01-11 17:06
 * @desc 线程终止登记表
 **/
public enum ThreadTerminationRegistry {
    INSTANCE;
    private final Set<Handler> handlers = new HashSet<>();

    public synchronized void register(Handler handler) {
        handlers.add(handler);
    }

    public void clearThreads() {
        //为保障线程安全，再遍历时将handlers复制一份
        final Set<Handler> handlerSnapshot;
        synchronized (this) {
            handlerSnapshot = new HashSet<>(handlers);
        }
        for (Handler handler : handlers) {
            handler.terminate();

        }
    }


    /**
     * 线程终止处理器
     * <p>
     * 封装了有关线程停止的知识
     *
     * @author Viscent Huang
     */
    public static interface Handler {
        void terminate();
    }
}
