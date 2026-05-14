package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateFeePaymentServlet")
public class UpdateFeePaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int paymentID =
				Integer.parseInt(request.getParameter("paymentID"));

		int studentID =
				Integer.parseInt(request.getParameter("studentID"));

		String newName =
				request.getParameter("studentName");

		String paymentDate =
				request.getParameter("paymentDate");

		double newAmount =
				Double.parseDouble(request.getParameter("amount"));

		String status =
				request.getParameter("status");

		String oldName = "";
		double oldAmount = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/collegefee",
					"root",
					"chai@28");

			PreparedStatement oldps =
					con.prepareStatement(
					"select * from feepayments where PaymentID=?");

			oldps.setInt(1, paymentID);

			ResultSet rs = oldps.executeQuery();

			if(rs.next()) {

				oldName = rs.getString("StudentName");
				oldAmount = rs.getDouble("Amount");
			}

			PreparedStatement ps =
					con.prepareStatement(
					"update feepayments set StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? where PaymentID=?");

			ps.setInt(1, studentID);
			ps.setString(2, newName);
			ps.setString(3, paymentDate);
			ps.setDouble(4, newAmount);
			ps.setString(5, status);
			ps.setInt(6, paymentID);

			ps.executeUpdate();

			out.println("<html>");
			out.println("<head>");

			out.println("<title>Updated</title>");

			out.println("<style>");

			out.println("body{");
			out.println("margin:0;");
			out.println("font-family:Arial;");
			out.println("background:#102b72;");
			out.println("display:flex;");
			out.println("justify-content:center;");
			out.println("align-items:center;");
			out.println("height:100vh;");
			out.println("}");

			out.println(".box{");
			out.println("background:#f2f2f2;");
			out.println("width:500px;");
			out.println("padding:50px;");
			out.println("border-radius:20px;");
			out.println("text-align:center;");
			out.println("}");

			out.println("h1{");
			out.println("color:green;");
			out.println("font-size:55px;");
			out.println("}");

			out.println("h2{");
			out.println("font-size:35px;");
			out.println("}");

			out.println("p{");
			out.println("font-size:28px;");
			out.println("}");

			out.println("a{");
			out.println("text-decoration:none;");
			out.println("background:#2d56d3;");
			out.println("color:white;");
			out.println("padding:15px 30px;");
			out.println("border-radius:10px;");
			out.println("font-size:22px;");
			out.println("}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<div class='box'>");

			out.println("<h1>Updated Successfully</h1>");

			out.println("<h2>Record ID : " + paymentID + "</h2>");

			out.println("<p><b>Name Updated:</b><br>");
			out.println(oldName + " → " + newName + "</p>");

			out.println("<p><b>Amount Updated:</b><br>");
			out.println("Rs. " + oldAmount + " → Rs. " + newAmount + "</p>");

			out.println("<br>");

			out.println("<a href='index.jsp'>Back</a>");

			out.println("</div>");

			out.println("</body>");

			out.println("</html>");

			con.close();

		} catch(Exception e) {

			out.println(e);
		}
	}
}