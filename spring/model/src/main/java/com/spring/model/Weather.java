package com.spring.model;

import lombok.Data;

import java.util.Date;

/**
 * @author ：panleilei
 * @description 天气实体类
 * @modified By：
 * @version:
 * @date ：Created in 2023/4/28 10:39
 */
@Data
public class Weather {
    private String city;
    private Integer temp_lo; // 低温
    private Integer temp_hi; // 高温
    private Float prcp; // 降水
    private Date date;
}
