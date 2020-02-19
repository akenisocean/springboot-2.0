package com.ocean.springcloud.oceandemo.controller.幂等测试;


import lombok.*;

/**
 * @author chao
 * @version 1.0
 * @desc 自定义异常
 * @date 2019年08月15日 14:38
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class DachaoException extends RuntimeException {
    private String code;
    @NonNull
    private String msg;

}
