package com.ocean.springcloud.oceandemo.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.data.redis.connection.ClusterInfo;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Properties;

/**
 * @author chao
 * @version 1.0
 * @desc
 * @date 2019年09月02日 12:26
 */
@Component
//@ConditionalOnEnabledHealthIndicator("myredis")
public class MyLajiRedisHealthIndicator extends AbstractHealthIndicator {

    static final String VERSION = "version";

    static final String REDIS_VERSION = "redis_version";

    private final RedisConnectionFactory redisConnectionFactory;

    public MyLajiRedisHealthIndicator(RedisConnectionFactory connectionFactory) {
        super("Redis health check failed");
        Assert.notNull(connectionFactory, "ConnectionFactory must not be null");
        this.redisConnectionFactory = connectionFactory;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        RedisConnection connection = RedisConnectionUtils
                .getConnection(this.redisConnectionFactory);
        try {
            if (connection instanceof RedisClusterConnection) {
                ClusterInfo clusterInfo = ((RedisClusterConnection) connection)
                        .clusterGetClusterInfo();
                builder.up().withDetail("cluster_size", clusterInfo.getClusterSize())
                        .withDetail("slots_up", clusterInfo.getSlotsOk())
                        .withDetail("slots_fail", clusterInfo.getSlotsFail());
            }
            else {
                Properties info = connection.info();
                builder.up().withDetail(VERSION, "3.1.1");
            }
        }
        finally {
            RedisConnectionUtils.releaseConnection(connection,
                    this.redisConnectionFactory);
        }
    }
}
