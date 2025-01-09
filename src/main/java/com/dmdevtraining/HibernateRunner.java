package com.dmdevtraining;

import com.dmdevtraining.entity.Company;
import com.dmdevtraining.entity.PersonalInfo;
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
        Company google = Company.builder()
            .name("Google")
            .build();
        User user = User.builder()
            .username("petr2@gmail.com")
            .personalInfo(PersonalInfo.builder()
                .firstname("Petr")
                .lastname("Petrov")
                .build())
            .company(google)
            .build();


        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {

                Transaction transaction = session1.beginTransaction();

                session1.save(google);
                session1.save(user);

                session1.getTransaction().commit();
            }


        }
    }
}
