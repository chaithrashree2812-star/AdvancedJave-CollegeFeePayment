package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String type = request.getParameter("type");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/collegefee",
					"root",
					"chai@28");

			if("overdue".equals(type)) {

				PreparedStatement ps =
						con.prepareStatement(
						"select * from feepayments where Status='Overdue'");

				ResultSet rs = ps.executeQuery();

				out.println("<html><body style='margin:0;font-family:Arial;background:#102b72;color:white;padding:40px;'>");

				out.println("<h1>Overdue Students</h1>");

				out.println("<table border='1' cellpadding='10' cellspacing='0' style='background:white;color:black;width:100%;border-collapse:collapse;'>");

				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Date</th>");
				out.println("<th>Amount</th>");
				out.println("<th>Status</th>");
				out.println("</tr>");

				while(rs.next()) {

					out.println("<tr>");

					out.println("<td>"+rs.getInt("PaymentID")+"</td>");
					out.println("<td>"+rs.getString("StudentName")+"</td>");
					out.println("<td>"+rs.getString("PaymentDate")+"</td>");
					out.println("<td>Rs. "+rs.getDouble("Amount")+"</td>");
					out.println("<td>"+rs.getString("Status")+"</td>");

					out.println("</tr>");
				}

				out.println("</table><br>");

				out.println("<a href='reports.jsp' style='color:white;'>Back</a>");

				out.println("</body></html>");
			}

			else if("range".equals(type)) {

				String fromDate =
						request.getParameter("fromDate");

				String toDate =
						request.getParameter("toDate");

				PreparedStatement ps =
						con.prepareStatement(
						"select sum(Amount) from feepayments where PaymentDate between ? and ?");

				ps.setString(1, fromDate);
				ps.setString(2, toDate);

				ResultSet rs = ps.executeQuery();

				double total = 0;

				if(rs.next()) {
					total = rs.getDouble(1);
				}

				out.println("<html><body style='margin:0;font-family:Arial;background:#102b72;color:white;text-align:center;padding-top:150px;'>");

				out.println("<div style='background:white;color:black;width:500px;margin:auto;padding:40px;border-radius:20px;'>");

				out.println("<h1>Collection Report</h1>");

				out.println("<h2>Total Collection</h2>");

				out.println("<h1 style='color:green;'>Rs. " + total + "</h1>");

				out.println("<p><b>From :</b> " + fromDate + "</p>");
				out.println("<p><b>To :</b> " + toDate + "</p>");

				out.println("<a href='reports.jsp'>Back</a>");

				out.println("</div></body></html>");
			}

			else if("paid".equals(type)) {

				PreparedStatement ps =
						con.prepareStatement(
						"select * from feepayments where Status='Paid'");

				ResultSet rs = ps.executeQuery();

				out.println("<html><body style='margin:0;font-family:Arial;background:#102b72;color:white;padding:40px;'>");

				out.println("<h1>Paid Students</h1>");

				out.println("<table border='1' cellpadding='10' cellspacing='0' style='background:white;color:black;width:100%;border-collapse:collapse;'>");

				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Date</th>");
				out.println("<th>Amount</th>");
				out.println("<th>Status</th>");
				out.println("</tr>");

				while(rs.next()) {

					out.println("<tr>");

					out.println("<td>"+rs.getInt("PaymentID")+"</td>");
					out.println("<td>"+rs.getString("StudentName")+"</td>");
					out.println("<td>"+rs.getString("PaymentDate")+"</td>");
					out.println("<td>Rs. "+rs.getDouble("Amount")+"</td>");
					out.println("<td>"+rs.getString("Status")+"</td>");

					out.println("</tr>");
				}

				out.println("</table><br>");

				out.println("<a href='reports.jsp' style='color:white;'>Back</a>");

				out.println("</body></html>");
			}

			con.close();

		} catch(Exception e) {

			out.println(e);
		}
	}
}