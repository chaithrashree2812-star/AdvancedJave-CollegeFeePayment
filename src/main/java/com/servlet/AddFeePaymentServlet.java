package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;

@WebServlet("/AddFeePaymentServlet")
public class AddFeePaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int studentID =
				Integer.parseInt(
				request.getParameter("studentID"));

		String studentName =
				request.getParameter("studentName");

		double amount =
				Double.parseDouble(
				request.getParameter("amount"));

		String status =
				request.getParameter("status");

		String paymentDate =
				new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss a")
				.format(new Date());

		FeePaymentDAO dao = new FeePaymentDAO();

		dao.addPayment(studentID,
				studentName,
				paymentDate,
				amount,
				status);

		out.println("<html>");

		out.println("<head>");

		out.println("<title>Added</title>");

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
		out.println("border-radius:25px;");
		out.println("text-align:center;");
		out.println("}");

		out.println("h1{");
		out.println("color:green;");
		out.println("font-size:55px;");
		out.println("}");

		out.println("p{");
		out.println("font-size:24px;");
		out.println("line-height:40px;");
		out.println("}");

		out.println("a{");
		out.println("text-decoration:none;");
		out.println("background:#3558d4;");
		out.println("color:white;");
		out.println("padding:15px 30px;");
		out.println("border-radius:10px;");
		out.println("font-size:22px;");
		out.println("font-weight:bold;");
		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='box'>");

		out.println("<h1>Payment Added Successfully</h1>");

		out.println("<p>");

		out.println("<b>Student ID :</b> "
				+ studentID + "<br>");

		out.println("<b>Student Name :</b> "
				+ studentName + "<br>");

		out.println("<b>Amount :</b> Rs. "
				+ amount + "<br>");

		out.println("<b>Status :</b> "
				+ status);

		out.println("</p>");

		out.println("<br>");

		out.println("<a href='index.jsp'>Home</a>");

		out.println("</div>");

		out.println("</body>");

		out.println("</html>");
	}
}