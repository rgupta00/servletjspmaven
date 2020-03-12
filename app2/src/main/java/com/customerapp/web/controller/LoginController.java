package com.customerapp.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customerapp.model.dao.user.User;
import com.customerapp.model.dao.user.UserDao;
import com.customerapp.model.dao.user.UserDaoImpl;
import com.customerapp.model.dao.user.UserNotFoundException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messageString=request.getParameter("message");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp?message="+messageString).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		
		UserDao dao=new UserDaoImpl();
		User user=null;
		try{
			user=dao.getUser(username, password);
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect("custController.do");
		}catch(UserNotFoundException ex){
			response.sendRedirect("login?message=login failed");
		}

	}

}
