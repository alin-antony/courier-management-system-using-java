

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ulogin
 */
@WebServlet("/Ulogin")
public class Ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ulogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","kavi1234");
		String qr="select * from user where email=? and pwd=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1, email);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			HttpSession session=request.getSession();
			session.setAttribute("uid", email);
			session.setMaxInactiveInterval(30);
			response.sendRedirect("form.html");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ulogin.html");
			rd.include(request, response);
			out.println("<center><b><font color=red size=6>Invalid id and password</b></font></center>");
		}
		con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	
		
	
	}

}
