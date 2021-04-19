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

@WebServlet(urlPatterns = {"/third"})
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name="";
		//cookie from client to server, use request object
		Cookie[] cookies = request.getCookies();
		
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("firstCookie")) {
					name=cookie.getValue();
					break;
				}
			}
		}
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>third servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>third servlet, Welcome "+name+" </h1>");
			out.println("</body>");
			out.println("</html>");
		}
	
	}

}
