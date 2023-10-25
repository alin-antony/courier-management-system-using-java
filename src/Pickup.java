

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Pickup
 */
@WebServlet("/Pickup")
public class Pickup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pickup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String s_name=request.getParameter("s_name");
		String s_address=request.getParameter("s_address");
		String s_pin=request.getParameter("s_pin");
		String s_mobile=request.getParameter("s_mobile");
		String s_email=request.getParameter("s_email");
		String s_city=request.getParameter("s_city");
		String s_state=request.getParameter("s_state");
		String s_dis=request.getParameter("s_dis");
		String r_name=request.getParameter("r_name");
		String r_address=request.getParameter("r_address");
		String r_pin=request.getParameter("r_pin");
		String r_mobile=request.getParameter("r_mobile");
		String r_email=request.getParameter("r_email");
		String r_city=request.getParameter("r_city");
		String r_state=request.getParameter("r_state");
		String r_dis=request.getParameter("r_dis");
		String Date=request.getParameter("Date");
		String p_time=request.getParameter("p_time");
		String opt=request.getParameter("opt");
		int pri=Integer.parseInt(request.getParameter("pri"));
		int qty=Integer.parseInt(request.getParameter("qty"));
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","kavi1234");
	String qr="insert into parcel values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1,s_name);
	ps.setString(2, s_address);
	ps.setString(3,s_pin);
	ps.setString(4,s_mobile);
	ps.setString(5,s_email);
	ps.setString(6,s_city);
	ps.setString(7,s_state);
	ps.setString(8,s_dis);
	ps.setString(9,r_name);
	ps.setString(10, r_address);
	ps.setString(11,r_pin);
	ps.setString(12,r_mobile);
	ps.setString(13,r_email);
	ps.setString(14,r_city);
	ps.setString(15,r_state);
	ps.setString(16,r_dis);
	ps.setString(17,Date);
	ps.setString(18,p_time);
	ps.setString(19,opt);
	ps.setInt(20,pri);
	ps.setInt(21,qty);
	
	int i=ps.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("index1.jsp");
		HttpSession session=request.getSession();
		session.setAttribute("s_name",s_name);
		session.setMaxInactiveInterval(30);
		
	
	}else
	{
		out.println("Your pickup request is not made.....");
	}
	con.close();

	}catch(Exception e)
	{
	 out.println(e);
	}

	}
	}


