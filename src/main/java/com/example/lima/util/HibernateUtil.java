package com.example.lima.util;

import com.example.lima.model.Order;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Order.class);
            return configuration
                    .buildSessionFactory(serviceRegistry);
        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is issue in hibernate util");
        }
    }
}
