package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;

@WebServlet("/DeleteFeePaymentServlet")
public class DeleteFeePaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int paymentID =
				Integer.parseInt(request.getParameter("paymentID"));

		FeePaymentDAO dao = new FeePaymentDAO();

		dao.deletePayment(paymentID);

		response.setContentType("text/html");

		response.getWriter().println(

		"<html>" +

		"<body style='margin:0;font-family:Arial;" +
		"background:#102b72;color:white;" +
		"text-align:center;padding-top:180px;'>" +

		"<div style='background:white;color:black;" +
		"width:500px;margin:auto;padding:40px;" +
		"border-radius:20px;'>" +

		"<h1 style='color:red;'>Payment Deleted Successfully</h1>" +

		"<br>" +

		"<a href='index.jsp' " +

		"style='text-decoration:none;" +
		"background:#2d56d3;color:white;" +
		"padding:15px 30px;border-radius:10px;" +
		"font-size:18px;font-weight:bold;'>Home</a>" +

		"</div></body></html>");
	}
}