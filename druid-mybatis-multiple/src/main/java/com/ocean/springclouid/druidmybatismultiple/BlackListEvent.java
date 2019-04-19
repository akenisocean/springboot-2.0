package com.ocean.springclouid.druidmybatismultiple;

import org.springframework.context.ApplicationEvent;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年04月08日 13:09
 */
public class BlackListEvent extends ApplicationEvent {


    private final String address;
    private final String content;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BlackListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }
}
