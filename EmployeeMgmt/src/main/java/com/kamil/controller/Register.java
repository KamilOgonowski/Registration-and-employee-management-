package com.kamil.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kamil.model.RegisterUserModel;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("uname"); 
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String password = request.getParameter("password");
		String cPassword = request.getParameter("cpassword");
		
		System.out.println(country);  //check
		// remember to add autoincremented ID while using hibernate
		
		if(password.equals(cPassword)) {
			RegisterUserModel admin1 = new RegisterUserModel();
			admin1.setUserName(userName);
			admin1.setCountry(country);
			admin1.setCity(city);
			admin1.setPassword(password);
			
			

		}else {}
		System.out.println("Password and confrimed password do not match!!! - add logic ");
		
		
		
	}

}
