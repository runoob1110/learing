package com.mybatis01.model;

import java.util.Date;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/10 15:12
 */
public class Weather {
    private String city;
    private int tempLo;
    private int tempHi;
    private Date date;


    public String getCity() {
        return city;
    }

    public int getTempLo() {
        return tempLo;
    }

    public int getTempHi() {
        return tempHi;
    }

    public Date getDate() {
        return date;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTempLo(int tempLo) {
        this.tempLo = tempLo;
    }

    public void setTempHi(int tempHi) {
        this.tempHi = tempHi;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", tempLo=" + tempLo +
                ", tempHi=" + tempHi +
                ", date=" + date +
                '}';
    }
}
