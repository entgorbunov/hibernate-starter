package com.dmdevtraining;

import com.dmdevtraining.converter.BirthDateConverter;
import com.dmdevtraining.entity.Birthdate;
import com.dmdevtraining.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;

import static com.dmdevtraining.entity.Role.ADMIN;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAttributeConverter(new BirthDateConverter(), true);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("Ok");

            session.beginTransaction();

            User user = User.builder()
                .username("ivan@gmail.com")
                .firstname("Ivan")
                .lastname("Ivanov")
                .birthDate(new Birthdate(LocalDate.of(2000, 1, 19)))
                .role(ADMIN)
                .build();

            session.save(user);
//            session.flush();
//
//            User savedUser = session.get(User.class, user.getUsername());
//            System.out.println(savedUser);

            session.getTransaction().commit();
        }

    }
}
