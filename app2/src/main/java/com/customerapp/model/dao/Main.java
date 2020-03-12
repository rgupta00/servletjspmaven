package com.customerapp.model.dao;

import java.text.ParseException;

import com.customerapp.model.dao.customer.Customer;
import com.customerapp.model.dao.customer.CustomerDao;
import com.customerapp.model.dao.customer.CustomerDaoImpl;
import com.customerapp.model.dao.user.User;
import com.customerapp.model.dao.user.UserDao;
import com.customerapp.model.dao.user.UserDaoImpl;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		
		UserDao dao=new UserDaoImpl();
		/*dao.addUser(new User("raj", "raj123", "admin"));
		dao.addUser(new User("ekta", "ekta123", "mgr"));
		dao.addUser(new User("gunika", "gun123", "emp"));
		*/
		
		User user=dao.getUser("rajkljlj", "raj123");
		System.out.println(user);
		
		/*CustomerDao dao=new CustomerDaoImpl();
		
		Customer customer=dao.removeCustomer(4);
		System.out.println(customer);
		*/
		
		//Customer customer=dao.getCustomerById(40);
		
		//Customer cust=dao.updateCustomer(4, "usa");
		
		//System.out.println(cust);
		
		/*SimpleDateFormat fmt=new SimpleDateFormat("dd/MM/yyyy");
		
		Date dob1=fmt.parse("11/11/2000");
		
		
		CustomerDao dao=new CustomerDaoImpl();
		Customer customer=new Customer("amit", "delhi",dob1 );
		Customer customer2=new Customer("sumit", "delhi",dob1 );
		Customer customer3=new Customer("kapil", "delhi",dob1 );
		Customer customer4=new Customer("raj", "delhi",dob1 );
		
		dao.addCustomer(customer);
		dao.addCustomer(customer2);
		dao.addCustomer(customer3);
		dao.addCustomer(customer4);
		
		*/
	}
}
