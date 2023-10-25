package com.mybatis01.dao;

import com.mybatis01.model.City;

import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/11 14:01
 */
public interface CityMapper {
    List<City> selectCity();
}
