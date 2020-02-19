package com.ocean.springcloud.oceanldap.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author: chao
 * @description: 测试请求实体类
 * @create: 2019-12-23 16:06
 */
@Data
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
