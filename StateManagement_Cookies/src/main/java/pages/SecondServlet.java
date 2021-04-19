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

@WebServlet(urlPatterns = {"/second"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name="";
		//cookie from client to server, use request object
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("firstCookie")) {
					name=cookie.getValue();
					//cookie.setValue("newValueSet"); // change the value of cookie
					//cookie.setMaxAge(0); //To delete cookie,so that the thirdServlet.java will not receive it. Set age to 0 value
					response.addCookie(cookie);
					break;
				}
			}
		}
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>second servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='third'>");
			out.println("<h1>second servlet, Welcome "+name+" </h1>");
			out.println("<input type='submit'value='third page'/>");
			out.print("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	
	}

}
