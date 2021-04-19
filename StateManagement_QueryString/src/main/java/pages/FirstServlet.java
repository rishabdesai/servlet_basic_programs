package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/first"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		//create cookie object and add value to store.
	
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>first servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>First servlet, Welcome "+name+" </h1>");
			//syntex : URL?key1=value1 & key2=value2;
			out.println("<a href ='second?firstCookie="+name+"'>Click here</a>");
			out.println("</body>");
			out.println("</html>");
		}
	
	}

}
