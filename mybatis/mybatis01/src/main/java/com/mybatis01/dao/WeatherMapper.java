package com.mybatis01.dao;

import com.mybatis01.model.Weather;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/10 15:36
 */
public interface WeatherMapper {
    Weather selectWeather(String name);
}
