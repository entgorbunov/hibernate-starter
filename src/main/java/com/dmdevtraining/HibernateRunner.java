package com.dmdevtraining;

import com.dmdevtraining.entity.User;
import com.dmdevtraining.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;

@Slf4j
public class HibernateRunner {
    public static void main(String[] args) throws SQLException {
        User user = User.builder()
            .username("ivan@gmail.com")
            .firstname("Ivan")
            .lastname("Ivanov")
            .build();

        log.info("User entity is in transient state, object {}", user);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {

                Transaction transaction = session1.beginTransaction();
                log.trace("Transaction is created, {}", transaction);

                session1.saveOrUpdate(user);
                log.trace("User is in persistent state: {}, session {}", user, session1);

                session1.getTransaction().commit();
            }

            log.warn("User is in detached state: {}, session is closed {}", user, session1);

        } catch (Exception e) {
            log.error("Exception occurred", e);
            throw e;
        }
    }
}
