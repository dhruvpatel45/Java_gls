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
import java.sql.SQLException;

/**
 * Servlet implementation class SignupValidation
 */
@WebServlet("/SignupValidation")
public class SignupValidation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignupValidation() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement p = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhruv", "root", "abcd");

            String sql = "INSERT INTO showroom_signup(fname,lname,email,uname,password) VALUES(?,?,?,?,?)";
            p = con.prepareStatement(sql);

            p.setString(1, fname);
            p.setString(2, lname);
            p.setString(3, email);
            p.setString(4, uname);
            p.setString(5, password);

            int rowCount = p.executeUpdate();

            if (rowCount > 0) {
                response.sendRedirect("showroom_owner_login");
            } else {
                out.println("Error: Unable to insert data. Please try again.");
            }

        } catch (ClassNotFoundException e) {
            out.println("Database Driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
        
            try {
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
