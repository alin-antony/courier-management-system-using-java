

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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
			String qr="update emp1 set id=?,sal=?,bname=? where name=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(4, name);
			ps.setString(1,id);
			ps.setString(2, sal);
			ps.setString(3, bname);
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("record updated");
			}
			else
			{
				out.println("no record updated");
			}
			con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}
}
