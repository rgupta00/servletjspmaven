package com.customerapp.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateFactory {

	private HibernateFactory() {
	}

	private static SessionFactory factory = null;

	public static SessionFactory getSessionFactory() {

		factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		return factory;
	}

}
