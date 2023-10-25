package com.mybatis01;

import com.mybatis01.dao.CityMapper;
import com.mybatis01.model.City;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ：panleilei
 * @description postgresql join on
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/11 13:55
 */
public class JoinOnTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        CityMapper mapper = session.getMapper(CityMapper.class);
        List<City> cities = mapper.selectCity();
        cities.stream().forEach(city -> {
            System.out.println(city);
        });
    }
}
