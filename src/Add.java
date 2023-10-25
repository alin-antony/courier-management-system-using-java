

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String sal=request.getParameter("sal");
		String bname=request.getParameter("bname");
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","kavi1234");
	String qr="insert into emp1 values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1,name);
	ps.setString(2,id);
	ps.setString(3,sal);
	ps.setString(4,bname);
	int i=ps.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("addst.html");
	
	}else
	{
		out.println("record not added");
	}
	con.close();

	}catch(Exception e)
	{
	 out.println(e);
	}

	}
	}


