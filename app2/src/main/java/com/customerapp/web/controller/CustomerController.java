package com.customerapp.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customerapp.model.dao.customer.Customer;
import com.customerapp.model.dao.customer.CustomerDao;
import com.customerapp.model.dao.customer.CustomerDaoImpl;


@WebServlet("/custController.do")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		CustomerDao dao = new CustomerDaoImpl();

		 if ("delete".equals(action)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			dao.removeCustomer(id);
			response.sendRedirect("custController.do?action=showall");
		} else if ("add".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/views/customer.jsp").forward(request,
					response);
		}else if ("update".equals(action)) {
			Integer customerId = Integer.parseInt(request.getParameter("id"));
			Customer customer=dao.getCustomerById(customerId);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/WEB-INF/views/update-customer.jsp").forward(request,
					response);
		}else{
			List<Customer> customers = dao.getAllCustomers();
			request.setAttribute("customers", customers);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/showall.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idString=request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String dobString = request.getParameter("dob");

		Date dob = null;
		try {
			dob = new SimpleDateFormat("dd/MM/yyyy").parse(dobString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		CustomerDao dao=new CustomerDaoImpl();
		if(idString==""){
		Customer customer=new Customer(name, address, dob);
		dao.addCustomer(customer);
		}else{
			Integer customerId = Integer.parseInt(request.getParameter("id"));
			dao.updateCustomer(customerId, address);
		}
		
		response.sendRedirect("custController.do?action=showall");
	}

}










