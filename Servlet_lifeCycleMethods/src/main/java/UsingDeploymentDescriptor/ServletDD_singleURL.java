package UsingDeploymentDescriptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDD_singleURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

		public ServletDD_singleURL() {
			System.out.println("inside constructor of " + this.getClass().getSimpleName());
		}
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			System.out.println("inside init() method of " + this.getClass().getSimpleName());
		}

		public void destroy() {
			System.out.println("inside destroy() method of " + this.getClass().getSimpleName());
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println(
					"inside doGet() method of " + this.getClass().getSimpleName() + "  :  " + Thread.currentThread());

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
