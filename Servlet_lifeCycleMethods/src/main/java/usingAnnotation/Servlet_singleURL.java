/*This program is simple demo of Dynamic web project.
 * - Open eclipse IDE and create new project
 * File > New > Dynamic Web Project > {give project name}>next>next> tick on Generate web.xml > 
 * add methods init(), destroy(), doGet()
 * -Using Annotation
 */

package usingAnnotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//use of annotation @WebServlet
@WebServlet("/first")
public class Servlet_singleURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

//constructor of servlet class
	public Servlet_singleURL() {
		System.out.println("inside constructor of " + this.getClass().getSimpleName());
	}
//init() method called once per servlet
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("inside init() method of " + this.getClass().getSimpleName());
	}

//destroy() method called once per servlet
	public void destroy() {
		System.out.println("inside destroy() method of " + this.getClass().getSimpleName());
	}

//called once per client request	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(
				"inside doGet() method of " + this.getClass().getSimpleName() + "  :  " + Thread.currentThread());

		//output will be display in browser
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Hello world </h1>" + new Date());
			out.println("</body>");
			out.println("</html");
		}

	}

}
