package com.ocean.springcloud.oceanmybaitsplus.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author: chao
 * @description: CallbackField
 * @create: 2020-03-11 17:23
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CallbackField extends BaseField {
    /** id */
    private Integer id;
    /** key */
    private String backKey;
    /** value */
    private String backValue;

}