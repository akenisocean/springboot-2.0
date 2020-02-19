package com.ocean.springcloud.oceankafka;

import lombok.Data;

import java.util.Date;

/**
 * @author: chao
 * @description:
 * @create: 2020-02-15 17:56
 */
@Data
public class Message {
  private long id;
  private String msg;
  private Date sendTime;

}
