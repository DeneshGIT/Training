package com.airways.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airways.doa.AddFlightDAO;
import com.airways.model.FormModelclass;
import com.airways.service.serverclass;

/**
 * Servlet implementation class Airways
 */
//@WebServlet("/Airways")
public class Airways extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Airways() {
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
		System.out.println("Connected with servlet");
		String flightname=request.getParameter("Flight Name");
		String Source=request.getParameter("Source");
		String fare=request.getParameter("fare");
		String Seats=request.getParameter("Seats");
		String Aname=request.getParameter("Aircraft name");
		
		FormModelclass Bookingmdl =new FormModelclass();
		Bookingmdl.setFlightname(flightname);
		Bookingmdl.setSource(Source);
		Bookingmdl.setFare(fare);
		Bookingmdl.setSeats(Seats);
		Bookingmdl.setAname(Aname);
		
		serverclass Serviceobj=new serverclass();
		boolean result2=Serviceobj.display(Bookingmdl);
		 if (result2) {
			System.out.println("Added to Database Succesfully");
			
			//AddFlightDAO Daoobj = new AddFlightDAO();
			//Daoobj.addFlightToDB(Bookingmdl);
			request.getRequestDispatcher("databasesuccess.jsp").forward(request,response);
			
			
			
		} else {
          response.sendRedirect("https://makemytrip.com");
		}
		
		 
		 
		 
		
		
	}

}
