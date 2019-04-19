package com.ocean.springclouid.druidmybatismultiple;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年04月08日 13:17
 */
@Component
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {
    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        System.out.println(Thread.currentThread().getName());
        // notify appropriate parties via notificationAddress...
        System.out.println("BlackListNotifier.onApplicationEvent开始执行了");
    }

    @PostConstruct
    public void haha(){
        System.out.println("BlackListNotifier.PostConstruct");
        setNotificationAddress("blacklist@example.org");
    }
}
