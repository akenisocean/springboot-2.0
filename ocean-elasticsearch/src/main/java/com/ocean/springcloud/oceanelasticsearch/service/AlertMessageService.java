package com.ocean.springcloud.oceanelasticsearch.service;

import com.alibaba.fastjson.JSON;
import com.ocean.springcloud.oceanelasticsearch.model.AlertMessage;
import com.ocean.springcloud.oceanelasticsearch.repository.AlertMessageRepository;
import com.ocean.springcloud.oceanelasticsearch.utils.BeanConvertUtil;
import lombok.SneakyThrows;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: chao
 * @description:
 * @create: 2020-12-05 21:01
 */
@Service
public class AlertMessageService {

    @Resource
    AlertMessageRepository alertMessageRepository;

    @Autowired
    RestHighLevelClient highLevelClient;

    public List<AlertMessage> insertAlertMessage(List<AlertMessage> alertMessageList) {
        return (List<AlertMessage>) alertMessageRepository.saveAll(alertMessageList);
    }

    public AlertMessage getById(String id) {
        return alertMessageRepository.findById(id).orElse(new AlertMessage());
    }

    @SneakyThrows
    public List<AlertMessage> searchAllAlertMessage() {
        SearchRequest searchRequest = new SearchRequest("alert_message");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("source", "资源监控");
        sourceBuilder.query(QueryBuilders.boolQuery().must(matchQueryBuilder));

        // 以batchId为分组条件，terms为分组后的字段名称，field为将被分组的字段名称
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("sourceTerm").field("source.keyword");
                // 分组求和integral字段，并将求和后的字段名改为score
                // subAggregation为子聚合，即在batchId分组后的小组内聚合
//                .subAggregation(AggregationBuilders.sum("score").field("integral"))
                // 注意这里，下面介绍
//                .subAggregation(AggregationBuilders.topHits("details").size(1));

        sourceBuilder.aggregation(aggregation);

        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse.getAggregations());
        return Arrays.stream(searchResponse.getHits().getHits()).map(this::convert).collect(Collectors.toList());

    }


    private AlertMessage convert(SearchHit searchHit) {
        return JSON.parseObject(searchHit.getSourceAsString(), AlertMessage.class);

    }

    @SneakyThrows
    public AlertMessage uapdate(AlertMessage alertMessage) {

        UpdateByQueryRequest updateRequest = new UpdateByQueryRequest("alert_message");
        updateRequest.setConflicts("proceed");
        updateRequest.setQuery(QueryBuilders.boolQuery()
                .filter(QueryBuilders.termQuery("currentStatus", 1))
                .filter(QueryBuilders.termQuery("triggerId", alertMessage.getTriggerId())));
        updateRequest.setScript(new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, combineUpdateSource(alertMessage), Collections.EMPTY_MAP));
        BulkByScrollResponse bulkByScrollResponse = highLevelClient.updateByQuery(updateRequest, RequestOptions.DEFAULT);
        System.out.println(bulkByScrollResponse.getStatus());
        return AlertMessage.builder().build();
    }


    /**
     * 通过script脚本修改对应的参数
     *
     * @param alertMessage
     * @return
     */
    private String combineUpdateSource(AlertMessage alertMessage) {
        Map<String, Object> sourceMap = BeanConvertUtil.object2Map(alertMessage);
        StringBuilder sourceBuilder = new StringBuilder();
        sourceMap.forEach((key, value) -> {
            if (Objects.nonNull(value)) {
                if (value instanceof Number) {
                    value = value.toString();
                } else if (value instanceof String) {
                    value = "'" + value.toString() + "'";
                } else if (value instanceof List) {
                    value = JSON.toJSON(value);
                } else {
                    value = value.toString();
                }
                sourceBuilder.append(String.format("ctx._source.%s=%s;", key, value));

            }

        });
        return sourceBuilder.toString();
    }

}
