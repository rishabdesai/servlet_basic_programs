package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		// pre-processing
		HttpSession session = req.getSession();
		Object cust = session.getAttribute("cust_security");
		
		//System.out.println("Accessing : " + uri + " , " + cust);
		if(cust != null) { // authenticated user
			// invoke next web-component in chain
			chain.doFilter(request, response);
			
		} else { // un-authenticated user
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
		
		// post-processing
	}
}