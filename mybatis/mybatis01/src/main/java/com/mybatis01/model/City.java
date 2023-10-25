package com.mybatis01.model;

import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/10 15:20
 */
public class City {
    private String name;
    private Object location;
    private List<Weather> weathers;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", weathers=" + weathers +
                '}';
    }
}
