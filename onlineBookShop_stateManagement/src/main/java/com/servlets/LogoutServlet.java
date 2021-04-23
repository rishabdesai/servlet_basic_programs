package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAO;
import com.entities.Book;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// -------------------------------------------------------
		//cookie step5
		//create same with same name and make the value field blank to destroy the cookie
		Cookie c = new Cookie("cookie_userName","");
		// -------------------------------------------------------

		// ++++++++++++++++++++++++++++++++++++++++++++++++++
		//session step-4
		//destroy session
		HttpSession session = req.getSession();
			session.invalidate();
		// ++++++++++++++++++++++++++++++++++++++++++++++++++
			
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>BookShop</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Thank you<br/>");
		out.println("<a href='index.html'>Login again</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
