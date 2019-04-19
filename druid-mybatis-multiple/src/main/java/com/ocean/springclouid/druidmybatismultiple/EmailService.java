package com.ocean.springclouid.druidmybatismultiple;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年04月08日 13:16
 */
@Service
public class EmailService implements ApplicationEventPublisherAware {

    private List<String> blackList;
    private ApplicationEventPublisher publisher;

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String content) {
        if (blackList.contains(address)) {
            publisher.publishEvent(new BlackListEvent(this, address, content));
        }
        // send email...
        System.out.println(Thread.currentThread().getName());
        System.out.println("send Email开始发送邮箱了"+address+"内容为："+content);

    }

    @PostConstruct
    public void haha(){
        System.out.println("EmailService.PostConstruct");
        List<String> list = new ArrayList<>(3);
        list.add("known.spammer@example.org");
        list.add("known.hacker@example.org");
        list.add("john.doe@example.org");
        setBlackList(list);
    }



}
