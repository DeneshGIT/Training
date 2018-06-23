package com.pro.container;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.business.probusinessclass;
import com.pro.db.prodbclass;
import com.pro.model.promodelclass;

/**
 * Servlet implementation class productservlet
 */
@WebServlet("/Registerform")

public class productservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productservlet() {
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
		System.out.println("ENTERED SERVLET");
		
		promodelclass modelobj = new promodelclass();
		modelobj.setEmpID(request.getParameter("empID"));
		modelobj.setEmpName(request.getParameter("empName"));
		modelobj.setDeptCode(request.getParameter("deptCode"));
		modelobj.setDOJ(request.getParameter("DOJ"));
		modelobj.setPassword(request.getParameter("Password"));
		modelobj.setConfirmPassword(request.getParameter("ConfirmPassword"));
		
		probusinessclass serviceobj = new probusinessclass();
		boolean adminresult2=serviceobj.adminvalidate(modelobj);
		
		System.out.println(adminresult2);
		if ( adminresult2 = true) 
		{
			System.out.println("Entered db");
			prodbclass dbobj = new prodbclass();
			//dbobj.addprotodb(modelobj);
			int result1 = dbobj.addprotodb(modelobj);
			System.out.println(result1);
			System.out.println(result1);
			if (result1 == 1) 
			{
				System.out.println("Value entered database successfully");
				request.getRequestDispatcher("prologin.jsp").forward(request,response);
			}
			
			else 
			{
				System.out.println("database error");
			}
		}
		
		
		
		
		
		
		
	}

}
