package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAO;
import com.entities.Book;

public class ShowCartServlet extends HttpServlet {
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

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>BookShop</title>");
		out.println("</head>");
		out.println("<body>");

		// -------------------------------------------------------
		//cookie step4
		// receive cookie from Loginservlet.java
		Cookie[] cookies = req.getCookies();
		String userName = "";
		for (Cookie c : cookies) {
			if (c.getName().equals("cookie_userName"))
				userName = c.getValue();
		}
		out.printf("<h1>Hello %s <hr/>\r\n", userName);
		// -------------------------------------------------------

		// ++++++++++++++++++++++++++++++++++++++++++++++++++
		//session step3
		// get bookIds from cart and display them
		HttpSession session = req.getSession();
		List<Integer> cart = (List<Integer>) session.getAttribute("cart");

		double total = 0.0;
		try (BookDAO dao = new BookDAO()) {
			dao.open();
			for (int id : cart) {
				Book b = dao.getBookById(id);
				total += b.getPrice();
				out.println(b.toString());
				out.println("<br/>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("Total<br/>");
		out.printf("Total amount : %.2f\r\n",total);
		out.println("Total<br/>");
		// ++++++++++++++++++++++++++++++++++++++++++++++++++
		
		out.println("<a href='logout'>sign out</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
