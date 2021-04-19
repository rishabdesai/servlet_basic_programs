package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import pojo.UserPOJO;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//using parameterless constructor of UserDao.java 
		try(userDao dao= new userDao()){
			UserPOJO user=new UserPOJO();
			user.setFullName(request.getParameter("fullname"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setBirthDate(request.getParameter("birthdate"));
		//	System.out.println(user.toString());
			dao.registerNewUser(user);
		
			
			response.setContentType("text/html");
			try(PrintWriter out= response.getWriter()){
				out.println("<html>");
				out.println("<head>");
				out.println("<title>registration page</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h3>Registration is successful </h3>");
				out.println("<h5> <a href='Login.html'> click here</a> to login</h5>");
				out.println("</body>");
				
				out.println("</html>");
				
			}
			
	} catch (Exception e) {
		throw new ServletException(e);
	}

}
}
