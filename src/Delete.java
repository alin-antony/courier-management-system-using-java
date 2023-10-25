

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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","kavi1234");
			String qr="delete from emp1 where id=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1,id);
			int i=ps.executeUpdate();
			if(i>0)
			{
				//response.sendRedirect("Show");
				RequestDispatcher rd=request.getRequestDispatcher("Show");
				rd.include(request, response);
				out.println(id+" record deleted");

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
