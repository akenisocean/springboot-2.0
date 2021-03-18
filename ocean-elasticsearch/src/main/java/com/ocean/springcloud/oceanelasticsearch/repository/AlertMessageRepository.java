package com.ocean.springcloud.oceanelasticsearch.repository;

import com.ocean.springcloud.oceanelasticsearch.model.AlertMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: chao
 * @description: 告警信息仓库
 * @create: 2020-12-05 18:09
 */
public interface AlertMessageRepository extends ElasticsearchRepository<AlertMessage,String> {


}
