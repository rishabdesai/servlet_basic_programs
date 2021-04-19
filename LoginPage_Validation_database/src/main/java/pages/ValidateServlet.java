package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import pojo.User;


@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email+"  :  "+password);
			
			
			
			
			
			try(userDao dao= new userDao()){
				User user = dao.validateEmailPassword(email, password);
			
				if (user !=null) {
					System.out.println(user.toString());
				}else {
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}

}
