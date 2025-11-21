package com.mybatis01;

import com.mybatis01.dao.WeatherMapper;
import com.mybatis01.model.Weather;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/10 15:07
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = factory.openSession();
////        Weather weather = session.selectOne("com.mybatis01.dao.WeatherMapper.selectWeather", "Hayward");
////        System.out.println(weather);
//
//        WeatherMapper mapper = session.getMapper(WeatherMapper.class);
//        Weather weather1 = mapper.selectWeather("Hayward");
//        System.out.println("weather1=== " +  weather1);

        System.out.println(212 / 100);

        String startTime = String.format("%02d:%02d", 15, 22);
        System.out.println(startTime);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);


        System.out.println(list.contains(list1));

    }
}
