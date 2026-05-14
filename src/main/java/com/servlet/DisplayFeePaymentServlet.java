package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DisplayFeePaymentServlet")
public class DisplayFeePaymentServlet extends HttpServlet {

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

			out.println("<head>");

			out.println("<title>Display Payments</title>");

			out.println("<style>");

			out.println("body{");
			out.println("margin:0;");
			out.println("font-family:Arial;");
			out.println("background:#102b72;");
			out.println("padding:40px;");
			out.println("}");

			out.println("h1{");
			out.println("color:white;");
			out.println("text-align:center;");
			out.println("font-size:55px;");
			out.println("margin-bottom:35px;");
			out.println("}");

			out.println("table{");
			out.println("width:100%;");
			out.println("border-collapse:collapse;");
			out.println("background:white;");
			out.println("}");

			out.println("th{");
			out.println("background:#2d56d3;");
			out.println("color:white;");
			out.println("padding:15px;");
			out.println("font-size:20px;");
			out.println("}");

			out.println("td{");
			out.println("padding:15px;");
			out.println("text-align:center;");
			out.println("font-size:18px;");
			out.println("border-bottom:1px solid #ccc;");
			out.println("}");

			out.println("tr:hover{");
			out.println("background:#f2f2f2;");
			out.println("}");

			out.println(".home{");
			out.println("display:inline-block;");
			out.println("margin-top:30px;");
			out.println("background:white;");
			out.println("color:#102b72;");
			out.println("padding:15px 30px;");
			out.println("text-decoration:none;");
			out.println("border-radius:10px;");
			out.println("font-size:22px;");
			out.println("font-weight:bold;");
			out.println("}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<h1>All Fee Payments</h1>");

			out.println("<table>");

			out.println("<tr>");
			out.println("<th>Payment ID</th>");
			out.println("<th>Student ID</th>");
			out.println("<th>Student Name</th>");
			out.println("<th>Payment Date</th>");
			out.println("<th>Amount</th>");
			out.println("<th>Status</th>");
			out.println("</tr>");

			while(rs.next()) {

				out.println("<tr>");

				out.println("<td>"
						+ rs.getInt("PaymentID")
						+ "</td>");

				out.println("<td>"
						+ rs.getInt("StudentID")
						+ "</td>");

				out.println("<td>"
						+ rs.getString("StudentName")
						+ "</td>");

				out.println("<td>"
						+ rs.getString("PaymentDate")
						+ "</td>");

				out.println("<td>Rs. "
						+ rs.getDouble("Amount")
						+ "</td>");

				out.println("<td>"
						+ rs.getString("Status")
						+ "</td>");

				out.println("</tr>");
			}

			out.println("</table>");

			out.println("<br><center>");

			out.println("<a href='index.jsp' class='home'>Home</a>");

			out.println("</center>");

			out.println("</body>");

			out.println("</html>");

			con.close();

		} catch(Exception e) {

			out.println(e);
		}
	}
}