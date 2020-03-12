package com.customerapp.model.dao.customer;

import java.io.Serializable;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.customerapp.model.dao.HibernateFactory;

public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory sessionFactory;

	public CustomerDaoImpl() {
		sessionFactory = HibernateFactory.getSessionFactory();
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> customers = session.createQuery("from customer_pojo")
				.list();
		session.close();
		return customers;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, customerId);
		if (customer == null)
			throw new CustomerNotFoundException("customer with id="
					+ customerId + " is not found");
		session.close();
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(customer);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		session.close();
		return customer;

	}

	@Override
	public Customer updateCustomer(int customerId, String address) {
		Session session = sessionFactory.openSession();
		Customer customer=null;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			 customer = getCustomerById(customerId);
			customer.setAddress(address);
			session.update(customer);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		session.close();
		return customer;
	}

	@Override
	public Customer removeCustomer(int customerId) {
		Session session = sessionFactory.openSession();
		Customer customer=null;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			 customer = getCustomerById(customerId);
			session.delete(customer);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		session.close();
		return customer;
	}

}





