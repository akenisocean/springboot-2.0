package com.ocean.springcloud.oceanelasticsearch;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static org.elasticsearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;

/**
 * @author: chao
 * @description: elasticsearch测试
 * @create: 2020-04-20 22:26
 */
@RestController
@RequestMapping("/es")
public class ElasticTestController {
    @Autowired
    RestHighLevelClient highLevelClient;
    @Autowired
    ReactiveElasticsearchClient reactiveElasticsearchClient;

    @GetMapping("/createIndex")
    public void test1() throws IOException {
        //创建一个spring-data的索引
        IndexRequest request = new IndexRequest("spring-data", "elasticsearch", UUID.randomUUID().toString())
                .source(Collections.singletonMap("feature", "high-level-rest-client"))
                .setRefreshPolicy(IMMEDIATE);

        IndexResponse response = highLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(request);
    }

    @GetMapping("/reactiveCreateIndex")
    public Mono<IndexResponse> queryIndex(){
        Mono<IndexResponse> index = reactiveElasticsearchClient.index(indexRequest -> {
            indexRequest.index("spring-data")
                    .type("elasticsearch")
                    .id(UUID.randomUUID().toString())
                    .source(Collections.singletonMap("feature", "reactive-client"))
                    .setRefreshPolicy(IMMEDIATE);
        });
        return index;

    }



}
