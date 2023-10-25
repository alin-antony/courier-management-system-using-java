

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<h1 align=center>Employee List</h1>");
		
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","kavi1234");
	String qr="select * from emp1";
 Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qr);
if(rs.next())
{
	out.println("<table align=center border=1px>");
	do
	{
		String name=rs.getString("name");
		String id=rs.getString("id");
		String sal=rs.getString("sal");
		String bname=rs.getString("bname");
		out.println("<tr>");
		out.println("<td>");
		out.println(name);
		out.println("</td>");
		out.println("<td>");
		out.println(id);
		out.println("</td>");
		out.println("<td>");
		out.println(sal);
		out.println("</td>");
		out.println("<td>");
		out.println(bname);
		out.println("</td>");
		out.println("<td>");
		out.println("<a href=Delete?name="+name+"&id="+id+">Delete</a>");
		out.println("</td>");
		out.println("<td>");
		out.println("<a href=UpdatePro?name="+name+"&id="+id+"&sal="+sal+"&bname="+bname+">Update</a>");
		out.println("</td>");
		out.println("</tr>");
	}while(rs.next());
	out.println("</table>");
}else
{
	out.println("no record found");
}
	con.close();

	}catch(Exception e)
	{
	 out.println(e);
	}
	}

	}
