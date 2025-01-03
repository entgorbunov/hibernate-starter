package com.dmdevtraining;

import com.dmdevtraining.entity.User;
import com.dmdevtraining.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {
        User user = User.builder()
            .username("ivan@gmail.com")
            .firstname("Ivan")
            .lastname("Ivanov")
            .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session1 = sessionFactory.openSession()) {

                session1.beginTransaction();

                session1.saveOrUpdate(user);

                session1.getTransaction().commit();
            }

            try (Session session2 = sessionFactory.openSession()) {

                session2.beginTransaction();

                session2.getTransaction().commit();
            }

        }
    }
}
