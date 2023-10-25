

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelPick
 */
@WebServlet("/DelPick")
public class DelPick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelPick() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String p_id=request.getParameter("p_id");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","kavi1234");
			String qr="delete from parcel where s_name=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1,p_id);
			int i=ps.executeUpdate();
			if(i>0)
			{
				//response.sendRedirect("Show");
				RequestDispatcher rd=request.getRequestDispatcher("ShowPick");
				rd.include(request, response);
				out.println(p_id+" record deleted");

			}
			else
			{
				out.println("no record deleted");
			}
			con.close();

		}catch(Exception e)
		{
			out.println(e);
		}
		
	
	}

}
