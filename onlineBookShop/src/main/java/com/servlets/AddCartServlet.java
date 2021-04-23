package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

//		HttpSession session = req.getSession();
//		List<Integer> cart = (List<Integer>) session.getAttribute("checkbox_subject");
//		
//		String[] bookIds =req.getParameterValues("checkbox_subject");
//		
//		int newBooks=0;
//		if(bookIds !=null) {
//			newBooks=bookIds.length;
//			for(String bookId :bookIds) {
//				int id=Integer.parseInt(bookId);
//				cart.add(id);
//			}
//		}
//		req.setAttribute("msg","new book added"+newBooks);
		
		List<Integer> list= new ArrayList<Integer>();
		
		String[] bookIds =req.getParameterValues("checkbox_subject");
		
		int newBooks=0;
		if(bookIds !=null) {
			newBooks=bookIds.length;
			for(String bookId :bookIds) {
				int id=Integer.parseInt(bookId);
				list.add(id);
			
			}
			System.out.println("Arrays : "+Arrays.toString(bookIds));
		}
		req.setAttribute("msg","new book added"+newBooks);
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("subjects");
		rd.forward(req, resp);
	}
}