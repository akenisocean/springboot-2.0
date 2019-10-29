package com.ocean.springcloud.oceandemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年07月11日 15:41
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/redis")
public class RedisController {

    static String watchkeys = "watchkeys";// 监视keys

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @PostConstruct
//    public void init(){
//        stringRedisTemplate.opsForSet().add(watchkeys, "0");// 重置watchkeys为0
//        Set<String> keys = new HashSet<>();
//        keys.add("setsucc");
//        keys.add("setfail");
//        stringRedisTemplate.delete(keys);// 清空抢成功的，与没有成功的
//    }

    @GetMapping("/secondKill")
    public void secondKill(){

    }

    public void haha(){
//        try {
//            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
//            redisTemplate.setEnableTransactionSupport(true);
//            redisTemplate.watch(watchkeys);// watchkeys
//
//            String val = redisTemplate.opsForValue().get(watchkeys);
//            int valint = Integer.valueOf(val);
//            String userifo = UUID.randomUUID().toString();
//            if (valint < 10) {
//                redisTemplate.multi();// 开启事务
//                redisTemplate.
//
//                tx.incr("watchkeys");
//
//                List<Object> list = tx.exec();// 提交事务，如果此时watchkeys被改动了，则返回null
//                if (list != null) {
//                    System.out.println("用户：" + userifo + "抢购成功，当前抢购成功人数:"
//                            + (valint + 1));
//                    /* 抢购成功业务逻辑 */
//                    jedis.sadd("setsucc", userifo);
//                } else {
//                    System.out.println("用户：" + userifo + "抢购失败");
//                    /* 抢购失败业务逻辑 */
//                    jedis.sadd("setfail", userifo);
//                }
//
//            } else {
//                System.out.println("用户：" + userifo + "抢购失败");
//                jedis.sadd("setfail", userifo);
//                // Thread.sleep(500);
//                return;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            jedis.close();
//        }
//
//    }

    }
}
