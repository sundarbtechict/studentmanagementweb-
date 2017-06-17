package com.sundar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit1
 */
public class Edit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit1() {
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
		String name = request.getParameter("name");
		System.out.println("HELLO: "+name);
		String regno = request.getParameter("regno");
		System.out.println("HELLO: "+regno);
		String dob = request.getParameter("dob");
		System.out.println("HELLO: "+dob);
		String email = request.getParameter("email");
		System.out.println("HELLO: "+email);
		String mobile = request.getParameter("mobile");
		System.out.println("HELLO: "+mobile);
		String  dept= request.getParameter("dept");
		System.out.println("HELLO: "+dept);
		try{
			Connection c=DbUtil.getConnection();
			PreparedStatement ps=c.prepareStatement("UPDATE STUDENT_MANAGEMENT "
					+ "SET NAME=?,DOB=?,DEPT=?,EMAIL=?,MOBILE=?"
					+ "WHERE REGNO=?");
			ps.setString(6, regno);
			ps.setString(1, name);
			ps.setString(2, dob);
			ps.setString(3, dept);
			ps.setString(4, email);
			ps.setString(5, mobile);
			int n=ps.executeUpdate();
			if(n==0)
				System.out.println("record is not inserted");
			else
				System.out.println("record is sucessfully inserted");
			ps.close();
			c.close();
			response.sendRedirect("./././index");

		}catch (Exception e){System.out.println(e);}

		doGet(request, response);
	}

}