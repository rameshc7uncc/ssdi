package com.infinityCableService.dbUtilTest;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class HibernateUtilTest {
 
    public static SessionFactory factory;
    //to disallow creating objects by other classes.
 
    private HibernateUtilTest() {
    }
    //maling the Hibernate SessionFactory object as singleton
 
    public static synchronized SessionFactory getSessionFactory() {
 
        if (factory == null) {
            factory = new Configuration().configure("hibernateTest.cfg.xml").
                    buildSessionFactory();
        }
        return factory;
    }
    
}



