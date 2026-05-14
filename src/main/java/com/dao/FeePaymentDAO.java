package com.dao;

import java.sql.*;

public class FeePaymentDAO {

	private Connection getConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/collegefee",
				"root",
				"chai@28");
	}

	public void addPayment(int studentID,
			String studentName,
			String paymentDate,
			double amount,
			String status) {

		try {

			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement(
			"insert into feepayments(StudentID,StudentName,PaymentDate,Amount,Status) values(?,?,?,?,?)");

			ps.setInt(1, studentID);
			ps.setString(2, studentName);
			ps.setString(3, paymentDate);
			ps.setDouble(4, amount);
			ps.setString(5, status);

			ps.executeUpdate();

			con.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePayment(int paymentID,
			int studentID,
			String studentName,
			String paymentDate,
			double amount,
			String status) {

		try {

			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement(
			"update feepayments set StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? where PaymentID=?");

			ps.setInt(1, studentID);
			ps.setString(2, studentName);
			ps.setString(3, paymentDate);
			ps.setDouble(4, amount);
			ps.setString(5, status);
			ps.setInt(6, paymentID);

			ps.executeUpdate();

			con.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePayment(int paymentID) {

		try {

			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement(
			"delete from feepayments where PaymentID=?");

			ps.setInt(1, paymentID);

			ps.executeUpdate();

			con.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}