package com.ocean.springcloud.oceanelasticjob.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: chao
 * @description: 订单
 * @create: 2020-04-05 23:03
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="sc_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    private BigDecimal amount;

    private Integer status;
    @Column(name="receive_name")
    private String receiveName;

    @Column(name="receive_address")
    private String receiveAddress;

    @Column(name="receive_mobile")
    private String receiveMobile;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

}
