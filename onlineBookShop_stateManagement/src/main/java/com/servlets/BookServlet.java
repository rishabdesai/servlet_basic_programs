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

import com.DAO.BookDAO;
import com.entities.Book;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String subject= req.getParameter("radio_subject");
				List<Book> books = new ArrayList<>();
				try(BookDAO dao= new BookDAO()) {
					dao.open();
					books=dao.getBookBySubject(subject);
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
				out.println("<a href='subjects'>Back</a>");
				//-------------------------------------------------------
				//cookie step3
				//receive cookie from Loginservlet.java 
				Cookie[] cookies = req.getCookies();
				String userName="";
				for(Cookie c: cookies) {
					if(c.getName().equals("cookie_userName"))
						userName=c.getValue();
				}
				out.printf("<h1>Hello %s <hr/>\r\n",userName);
				//-------------------------------------------------------
				
				out.println("<form action='addcart'>");
				
				
				for(Book b : books)
					out.printf("<input type='checkbox', name='checkbox_subject' value='%s'/> %s <br/>\r\t" +
								"<a href='books?radio_subject=%s&id=%d'> details</a><br/>\r\n",
								b.getId(),b.getName(),subject,b.getId());
				
				out.println("<input type='submit', value='Add to cart'/>");
				out.println("</form");
				
				String bookId= req.getParameter("id");
				if(bookId !=null) {
					int id=Integer.parseInt(bookId);
					try(BookDAO dao=new BookDAO()){
						dao.open();
						Book b= dao.getBookById(id);
						out.println("<div>");
						out.println(b.toString());
						out.println("</div>");
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
				

				out.println("</body>");
				out.println("</html>");
	}
}
