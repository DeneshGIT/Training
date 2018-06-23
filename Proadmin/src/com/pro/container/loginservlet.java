package com.pro.container;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.db.prodbclass;
import com.pro.model.promodelclass;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/Loginform")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		
		
		/////prodbclass doa = new prodbclass();
		////List<promodelclass> db2 = doa.fetchfromdb(modelobj);
        
		////request.setAttribute("listofpro", db2);
		/////request.getRequestDispatcher(".jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("ENTERED LOGIN SERVLET");

		promodelclass modelobj = new promodelclass();
		modelobj.setUsername(request.getParameter("Username"));
		modelobj.setUPassword(request.getParameter("UPassword"));
		prodbclass db2obj = new prodbclass();
		int result2 = db2obj.getfromdb(modelobj);
		System.out.println(result2);

		if (result2 > 0) {
			System.out.println("Logged in successfully");
			request.getRequestDispatcher("Display.jsp").forward(request, response);

		} else
			request.getRequestDispatcher("prologin.jsp").forward(request, response);
	}

}
