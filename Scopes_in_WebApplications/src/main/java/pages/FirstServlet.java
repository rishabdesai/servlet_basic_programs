package pages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/first" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("IndexPageUserName");

		
		//REQUEST scope - one per client request
		//parameter come from html page to servlet
		request.setAttribute("RequestScopeName", name);

		//SESSION scope - one per client
		//Attribute come from one server to another servlet
		HttpSession session = request.getSession();
		session.setAttribute("SessionScope", name);

		//APPLICATION scope - one per web application
		ServletContext application = this.getServletContext();
		application.setAttribute("ApplicationScope", name);

		//response.sendRedirect("second");   //new request
		
		RequestDispatcher rd = request.getRequestDispatcher("/second");
		rd.forward(request, response);

	}

}
