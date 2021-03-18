package com.ocean.springcloud.oceanthirddemo.flatmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chao
 * @description 消费数据
 * @create 2021-01-18 22:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;
}
