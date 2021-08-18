package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		
		return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}
}
