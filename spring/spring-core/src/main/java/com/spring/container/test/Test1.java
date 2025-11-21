package com.spring.container.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/8/1 13:50
 */
public class Test1 {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml"
        );
        Object city = beanFactory.getBean("city");
        System.out.println();
    }
}
