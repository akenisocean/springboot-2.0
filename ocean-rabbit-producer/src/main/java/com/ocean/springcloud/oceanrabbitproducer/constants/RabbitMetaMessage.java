package com.ocean.springcloud.oceanrabbitproducer.constants;

import lombok.Data;

/**
 * <p><b>Description:</b> 常量类 <p>
 * <b>Company:</b>
 *
 * @author created by hongda at 22:49 on 2017-10-23
 * @version V0.1
 */
@Data
public class RabbitMetaMessage {
    private String exchange;
    private String routingKey;
    private boolean autoTrigger;
    private boolean returnCallback;
    private Object payload;
}
