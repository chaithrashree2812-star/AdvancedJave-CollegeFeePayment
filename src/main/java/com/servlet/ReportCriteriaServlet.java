package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ReportCriteriaServlet")
public class ReportCriteriaServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");

		if(type.equals("range")) {

			response.sendRedirect("daterange.jsp");
		}
		else {

			response.sendRedirect(
			"ReportServlet?type=" + type);
		}
	}
}