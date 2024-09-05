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
 * Servlet implementation class Cardisplay
 */
public class Cardisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cardisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhruv", "root", "abcd");

            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: 'Poppins', sans-serif;");
            out.println("    background-color: #f4f4f4;");
            out.println("    margin: 0;");
            out.println("    padding: 20px;");
            out.println("}");
            out.println("h2 {");
            out.println("    color: #007bff;");
            out.println("}");
            out.println("table {");
            out.println("    width: 100%;");
            out.println("    border-collapse: collapse;");
            out.println("    margin-bottom: 20px;");
            out.println("}");
            out.println("table, th, td {");
            out.println("    border: 1px solid #ddd;");
            out.println("}");
            out.println("th, td {");
            out.println("    padding: 12px;");
            out.println("    text-align: left;");
            out.println("}");
            out.println("th {");
            out.println("    background-color: #007bff;");
            out.println("    color: white;");
            out.println("}");
            out.println("tr:nth-child(even) {");
            out.println("    background-color: #f2f2f2;");
            out.println("}");
            out.println("a {");
            out.println("    display: inline-block;");
            out.println("    margin: 10px 0;");
            out.println("    text-decoration: none;");
            out.println("    padding: 10px 20px;");
            out.println("    background-color: #007bff;");
            out.println("    color: white;");
            out.println("    border-radius: 5px;");
            out.println("    transition: background-color 0.3s ease;");
            out.println("}");
            out.println("a:hover {");
            out.println("    background-color: #0056b3;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h2> Showroom Owner/Staff Information</h2>");
            out.println("<table>");
            out.println("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Username</th><th>Password</th></tr>");

            PreparedStatement p1 = con.prepareStatement("SELECT * FROM showroom_signup");
            ResultSet r1 = p1.executeQuery();

            while (r1.next()) {
                String fname = r1.getString(1);
                String lname = r1.getString(2);
                String email = r1.getString(3);
                String uname = r1.getString(4);
                String password = r1.getString(5);

                out.println("<tr>");
                out.println("<td>" + fname + "</td>"); 
                out.println("<td>" + lname + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + uname + "</td>");
                out.println("<td>" + password + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            out.println("<h2>Car Information</h2>");
            out.println("<table>");
            out.println("<tr><th>Car Name</th><th>Count</th><th>Price</th><th>Year</th></tr>");

            PreparedStatement p2 = con.prepareStatement("SELECT * FROM car_info");
            ResultSet r2 = p2.executeQuery();

            while (r2.next()) {
                String carname = r2.getString(1);
                String count = r2.getString(2);
                String price = r2.getString(3);
                String year = r2.getString(4);

                out.println("<tr>");
                out.println("<td>" + carname + "</td>");
                out.println("<td>" + count + "</td>");
                out.println("<td>" + price + "</td>");
                out.println("<td>" + year + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            out.println("<a href='car_delete.jsp'>Delete Car Record</a><br>");
            out.println("<a href='Car_update.jsp'>Update Car Record</a><br>");
            out.println("<a href='showroom_owner_login.jsp'>Go to Login page</a><br>");
            out.println("<a href='showroom_owner_registration.jsp'>Go to Signup page</a><br>");

            out.println("</body>");
            out.println("</html>");



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        } finally {
            out.close();
        }
    }
		// TODO Auto-generated method stub


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
