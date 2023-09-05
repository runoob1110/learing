package com.spring.container.service;

import com.spring.container.dao.CityDao;
import com.spring.model.City;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/4/28 11:06
 */
public class CityService {
    private CityDao cityDao;
    public int saveCity(City city){
        return cityDao.saveCity(city);
    }
}
