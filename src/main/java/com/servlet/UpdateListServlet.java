package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateListServlet")
public class UpdateListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/collegefee",
					"root",
					"chai@28");

			PreparedStatement ps =
					con.prepareStatement(
					"select * from feepayments");

			ResultSet rs = ps.executeQuery();

			out.println("<html>");
			out.println("<body style='margin:0;font-family:Arial;background:#102b72;padding:40px;'>");

			out.println("<h1 style='color:white;text-align:center;'>Update Payments</h1>");

			out.println("<table border='1' cellpadding='15' cellspacing='0' style='background:white;width:100%;border-collapse:collapse;text-align:center;'>");

			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Student ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Date</th>");
			out.println("<th>Amount</th>");
			out.println("<th>Status</th>");
			out.println("<th>Action</th>");
			out.println("</tr>");

			while(rs.next()) {

				int id = rs.getInt("PaymentID");

				out.println("<tr>");

				out.println("<td>"+id+"</td>");
				out.println("<td>"+rs.getInt("StudentID")+"</td>");
				out.println("<td>"+rs.getString("StudentName")+"</td>");
				out.println("<td>"+rs.getString("PaymentDate")+"</td>");
				out.println("<td>Rs. "+rs.getDouble("Amount")+"</td>");
				out.println("<td>"+rs.getString("Status")+"</td>");

				out.println("<td>");

				out.println("<a href='feepaymentupdate.jsp?id="+id+"' " +
						"style='background:#2d56d3;color:white;padding:10px 20px;text-decoration:none;border-radius:8px;'>Update</a>");

				out.println("</td>");

				out.println("</tr>");
			}

			out.println("</table>");

			out.println("<br><br>");

			out.println("<div style='text-align:center;'>");

			out.println("<a href='index.jsp' " +
					"style='background:white;color:#102b72;padding:15px 30px;text-decoration:none;border-radius:10px;font-size:20px;font-weight:bold;'>Home</a>");

			out.println("</div>");

			out.println("</body>");
			out.println("</html>");

			con.close();

		} catch(Exception e) {

			out.println(e);
		}
	}
}