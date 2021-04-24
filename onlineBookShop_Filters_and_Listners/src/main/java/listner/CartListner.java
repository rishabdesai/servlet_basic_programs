package listner;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CartListner implements HttpSessionListener, ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application started....");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Application stopped....");
	}

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("new session created...");
		HttpSession session = se.getSession();
		session.setAttribute("cart", new ArrayList<Integer>());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session destoryed...");
	}

}
