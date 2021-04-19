# servlet_basics

### What is Servlet?

Servlet is a class which is executed on server side (within Web Container), when client makes request and generate response which is send back to client.

Servlet is a application in terms of javaEE standards, that allow us to develop Dynamic Web Application using java.

Servlet class must inherited from *javax.servlet.Servlet* interface directly or indirectly, more specifically *javax.servlet.http.HttpServlet*.

In Apache-Tomcat, the folder lib contains *servlet-api.jar* file, which contains implementation of servlet specification.

In case of MVC application, servlet is designed to use as a controller.

### Explain *javax.servlet.Servlet* interface

Servlet interface contains life cycle methods

* init(ServletConfig config) - Called only once (in life time of servlet object) after creation of object (after constructor) - 
* destroy() - called only once (in life of servlet object) before destroying the servlet object (before garbage collector is called)
* service(ServletRequest req, ServletResponse res)  - for each client request, web container call service method


### Explain interface ServletConfig

- It represents configuration given in *web.xml* file.
- Once ServletConfig object is created per servlet.
- web-container hand over the config object to the server as a argument to the init() method.

### Explain ServletContext

- It represents web application (/)
- One ServletConfig object per application.
- To store data globally, so that it can be accessed for all requests.