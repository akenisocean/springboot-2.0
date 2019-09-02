package com.ocean.springcloud.oceandemo.controller.幂等测试;

import com.ocean.springcloud.oceandemo.util.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年08月15日 13:14
 */
@Service
public class TokenService {

    private static final String TOKEN_NAME = "token";

    @Autowired
    private StringRedisTemplate redisTemplate;

    public ServerResponse createToken() {
        String str = RandomUtils.UUID32();
        StrBuilder token = new StrBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);
        redisTemplate.opsForValue().set(token.toString(), token.toString(),Constant.Redis.EXPIRE_TIME_MINUTE,TimeUnit.MINUTES);
        return ServerResponse.success(token.toString());
    }


    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if (StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(TOKEN_NAME);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new DachaoException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }
        if (!redisTemplate.hasKey(token)) {
            throw new DachaoException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        Long del = redisTemplate.delete(Arrays.asList(token));
        if (del <= 0) {
            throw new DachaoException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }
}
