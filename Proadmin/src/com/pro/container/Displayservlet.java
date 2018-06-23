package com.pro.container;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.db.prodbclass;
import com.pro.model.promodelclass;

/**
 * Servlet implementation class Displayservlet
 */
@WebServlet("/showthelist")
public class Displayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Displayservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		promodelclass modelobj = new promodelclass();
		//modelobj.setUsername(request.getParameter("Username"));
		//modelobj.setUPassword(request.getParameter("UPassword"));
		/*promodelclass modelobj = new promodelclass();
		modelobj.setUsername(request.getParameter("Username"));
		modelobj.setUPassword(request.getParameter("UPassword"));
		
		System.out.println(modelobj.getUsername());
		System.out.println(modelobj.getUPassword());*/
		System.out.println("ABOVE ARE DISPLAY");
		prodbclass doa = new prodbclass();
		List<promodelclass> db2 = doa.fetchfromdb(modelobj);
        
		request.setAttribute("listofpro", db2);
		request.getRequestDispatcher("Registeredmem.jsp").forward(request, response);
		
	}

}
