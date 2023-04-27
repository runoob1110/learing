package com.hibernate01.test;

import com.hibernate01.entity.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/3/12 22:13
 */
public class Test01 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Event event = new Event();
        event.setName("zhangsan");
        session.save(event);
        session.beginTransaction().commit();
        session.close();

    }
}
