package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CustomerDAO;
import com.entities.Customer;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		// authenticate user
		boolean success = false;
		Customer cust = null;
		try(CustomerDAO dao = new CustomerDAO()) {
			dao.open();
			cust = dao.getCustomer(email);
			if(cust != null && cust.getPassword().equals(password))
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(success) {
			
			//-------------------------------------------------------
			//cookie step-1
			//create cookie for username and add into response
			Cookie c = new Cookie("cookie_userName", cust.getName());
			resp.addCookie(c);
			//retrieve the cookie in 
			//-------------------------------------------------------
			
	
	
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++
			//session step-1
			//create empty cart and add to the session
			HttpSession session = req.getSession();
			//take empty array of integers to store the id of books
			List<Integer> cart = new ArrayList<>();
			//add to session
			session.setAttribute("cart", cart);
			//now go to AddCartServlet.java to get the session values
			//++++++++++++++++++++++++++++++++++++++++++++++++++
				
			// if success go to subject servlet
			resp.sendRedirect("subjects");
			
			//===========================================
			// Url-rewriting 
			//resp.sendRedirect(resp.encodeRedirectURL("subjects"));
			//===========================================		
		
		} else {
			// if failed show message.
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>BookShop</title>");
			out.println("</head>");
			
			
			out.println("<body>");
			out.println("<h3>Invalid email or password.</h3><br/>");
			out.println("<a href='index.html'>Login again</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}





