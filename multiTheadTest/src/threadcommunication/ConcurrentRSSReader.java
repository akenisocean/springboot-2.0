package threadcommunication;

import util.Tools;

import java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author jack chao
 * @create 2019-01-09 17:00
 * @desc 边现在边解析的RSS阅读器
 **/
public class ConcurrentRSSReader {
    public static void main(String[] args) throws Exception {
        final int argc = args.length;
        String url = argc > 0 ? args[0] : "http://lorem-rss.herokuapp.com/feed";

        //从网络加载RSS数据
        InputStream in = lozadRSS(url);


    }

    private static InputStream lozadRSS(String url) throws IOException {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(in);
        Thread workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doDownload(url, pos);
                } catch (Exception e) {
                    //RSS数据下载过程中出现异常时，关闭相关输入流和输出流
                    //注意此时我们不饿能像平常那样在finally块中关闭相关输出流
                    Tools.silentClose(pos, in);
                    e.printStackTrace();

                }
            }
        }, "rss-loader");
        workerThread.start();
        return in;
    }

    private static void doDownload(String url, PipedOutputStream pos) {
        ReadableByteChannel readChannel = null;
        WritableByteChannel writeChannel = null;

        //对指定的url发送HTTP请求
        BufferedInputStream in = issueRequest(url);


    }

    /**
     * 对指定的url发送HTTP请求
     *
     * @param url
     * @return
     */
    private static BufferedInputStream issueRequest(String url) {

        return null;
    }
}
