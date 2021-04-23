package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	
			// if success go to subject servlet
			resp.sendRedirect("subjects");
			//resp.sendRedirect(resp.encodeRedirectURL("subjects"));
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




