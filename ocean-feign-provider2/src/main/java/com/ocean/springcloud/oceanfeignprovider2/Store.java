package com.ocean.springcloud.oceanfeignprovider2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 季超
 * @create 2018-12-21 12:32
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private String id;
    private String name;
    private String password;
}
