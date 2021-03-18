package com.ocean.springcloud.oceanelasticsearch;

import com.ocean.springcloud.oceanelasticsearch.model.AlertMessage;
import com.ocean.springcloud.oceanelasticsearch.service.AlertMessageService;
import lombok.SneakyThrows;
import net.minidev.json.JSONObject;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OceanElasticsearchApplicationTests {


    @Resource
    AlertMessageService alertMessageService;

    @Autowired
    RestHighLevelClient highLevelClient;


    @Test
    void contextLoads() {

        List<AlertMessage> alertMessages = alertMessageService.searchAllAlertMessage();
        assertThat(!alertMessages.isEmpty());

    }

    /**
     * 批量添加测试数据
     */
    @Test
    void batchInsertMessage() {

    }


    @SneakyThrows
    @Test
    public void batchInsert() {
        BulkRequest bulkRequest = new BulkRequest("nginx-log_2020-12-14");

        for (int x = 0; x < 1500; x++) {
            Random random = new Random();
            String randomIp = getRandomIp();
            for (int y = 0; y < random.nextInt(50); y++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("IP", randomIp);
                jsonObject.put("message", "- - [14/Dec/2020:13:44:44 +0800] \\\"GET /monitor/assets/img/icon-sprite.svg HTTP/1.1\\\" 200 90192 \\\"http://10.18.111.33/monitor/assets/styles/blue-theme.css\\\" \\\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36");
                Map<String, Object> map = new HashMap<>();
                map.put("messages", jsonObject);
                map.put("createTime", 1608101528);
                map.put("endTime", 1608101528);
                map.put("resx", UUID.randomUUID().toString());
                IndexRequest indexRequest = new IndexRequest();
                indexRequest.source(map);
                bulkRequest.add(indexRequest);
            }
        }


        BulkResponse bulk = highLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        assertThat(bulk.hasFailures());

    }

    public static String getRandomIp() {
        // ip范围
        int[][] range = {
                {607649792, 608174079}, // 36.56.0.0-36.63.255.255
                {1038614528, 1039007743}, // 61.232.0.0-61.237.255.255
                {1783627776, 1784676351}, // 106.80.0.0-106.95.255.255
                {2035023872, 2035154943}, // 121.76.0.0-121.77.255.255
                {2078801920, 2079064063}, // 123.232.0.0-123.235.255.255
                {-1950089216, -1948778497}, // 139.196.0.0-139.215.255.255
                {-1425539072, -1425014785}, // 171.8.0.0-171.15.255.255
                {-1236271104, -1235419137}, // 182.80.0.0-182.92.255.255
                {-770113536, -768606209}, // 210.25.0.0-210.47.255.255
                {-569376768, -564133889}, // 222.16.0.0-222.95.255.255
        };

        Random random = new Random();
        int index = random.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /*
     * 将十进制转换成IP地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        String ipStr = "";
        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        ipStr = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

        return ipStr;
    }


}
