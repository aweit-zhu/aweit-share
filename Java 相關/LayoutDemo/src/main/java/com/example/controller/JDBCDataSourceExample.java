package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.config.EmployeeDBDataSource;

@WebServlet("/JDBCDataSourceExample")
public class JDBCDataSourceExample extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (Connection con = EmployeeDBDataSource.getDataSource().getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");) {

			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.print("<html><body><h2>Employee Details</h2>");
			out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
			out.print("<th>Employee ID</th>");
			out.print("<th>Employee FirstName</th>");
			out.print("<th>Employee LastName</th>");
			out.print("<th>Employee BirthDate</th>");
			out.print("<th>Employee Salary</th>");

			while (rs.next()) {
				int empID = rs.getInt("ID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				Date birthDate = rs.getDate("BirthDate");
				float salary = rs.getFloat("Salary");
				out.print("<tr>");
				out.print("<td>" + empID + "</td>");
				out.print("<td>" + first + "</td>");
				out.print("<td>" + last + "</td>");
				out.print("<td>" + birthDate + "</td>");
				out.print("<td>" + salary + "</td>");
				out.print("</tr>");
			}
			out.print("</table></body><br/>");

			out.print("<h3>Database Details</h3>");
			out.print("Database Product: " + con.getMetaData().getDatabaseProductName() + "<br/>");
			out.print("Database Driver: " + con.getMetaData().getDriverName());
			out.print("</html>");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
}
