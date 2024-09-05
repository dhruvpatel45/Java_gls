package car.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Servlet implementation class UpdateValidatio
 */
public class UpdateValidatio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateValidatio() {
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

		var carname=request.getParameter("carname");
		var count=request.getParameter("count");
		var price=request.getParameter("price");
		var year=request.getParameter("year");
	
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhruv","root","abcd");
			PreparedStatement p1=con.prepareStatement("UPDATE student_signup SET count=?,price=? WHERE carname=?");
			PreparedStatement p2=con.prepareStatement("UPDATE student_homepage SET carname=?,count=?,price=?,year=? WHERE carname=?");
			
			p1.setString(1, carname);
			p1.setString(2, count);
			p1.setString(3, price);
			p1.setString(4, year);
			
			p2.setString(1, carname);
			p2.setString(2, count);
			p2.setString(3, price);
			p2.setString(4, year);
			
			p1.executeUpdate();
			p2.executeUpdate();
			
			response.sendRedirect("Cardisplay");
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
