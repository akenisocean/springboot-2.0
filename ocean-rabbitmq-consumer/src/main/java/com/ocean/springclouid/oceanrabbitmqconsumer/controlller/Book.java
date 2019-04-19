package com.ocean.springclouid.oceanrabbitmqconsumer.controlller;

import lombok.Builder;
import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年04月01日 22:29
 */
@Data
@Builder
public class Book {
    private String name;
    private Double price;

}
