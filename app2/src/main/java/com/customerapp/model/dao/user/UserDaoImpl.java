package com.customerapp.model.dao.user;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.customerapp.model.dao.HibernateFactory;
import com.customerapp.model.dao.customer.Customer;

public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;

	public UserDaoImpl() {
		sessionFactory = HibernateFactory.getSessionFactory();
	}

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(user);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		session.close();
		
	}

	@Override
	public User getUser(String username, String password) {
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings({ "unchecked"})
		List<User> users=session
				.createQuery("select u from User u where u.name=:name and u.password=:password")
				.setString("name", username)
				.setString("password", password)
				.list();
		if(users.size()>0){
			return users.get(0);
		}else
			throw new UserNotFoundException("user not found");
		
	}

}









