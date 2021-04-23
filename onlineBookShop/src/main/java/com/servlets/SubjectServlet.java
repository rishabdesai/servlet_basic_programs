package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.BookDAO;

public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> subjects = new ArrayList<>();
		try(BookDAO dao=new BookDAO()){
			dao.open();
			subjects = dao.getSubjects();
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>BookShop</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='books'>");
		for(String s : subjects)
			out.printf("<input type='radio', name='radio_subject' value='%s'/> %s <br/>\r\n" ,s,s);
		out.println("<input type='submit' value='show books'/>");
		out.println("</form>");
		
		
		
		out.println("</body>");
		out.println("</html>");
	
		
	}
}