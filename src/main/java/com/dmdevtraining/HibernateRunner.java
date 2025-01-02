package com.dmdevtraining;

import com.dmdevtraining.entity.User;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAttributeConverter(new BirthDateConverter(), true);
        configuration.registerTypeOverride(new JsonBinaryType());

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("Ok");

            session.beginTransaction();

//            User user = User.builder()
//                .username("ivan9@gmail.com")
//                .firstname("Ivan")
//                .lastname("Ivanov")
//                .info("""
//                      {
//                                "id": 25,
//                                "name": "Ivan"
//                            }
//                    """)
//                .birthDate(new Birthdate(LocalDate.of(2000, 1, 19)))
//                .role(ADMIN)
//                .build();

//            session.delete(user);
//
            User user = session.get(User.class, "ivan9@gmail.com");
            System.out.println(user);

//            session.evict(user);
//            session.clear();
//            session.close();

            session.getTransaction().commit();
        }

    }
}
