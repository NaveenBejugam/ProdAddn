package com.Addn;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			  
            // Initialize the database
            Connection conn = DatabaseConnection.initializeDatabase();
  
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            PreparedStatement stmt = conn.prepareStatement("insert into student values(?, ?, ?, ? ,?)");
            
            stmt.setInt(1, Integer.valueOf(request.getParameter("id")));
            stmt.setString(2, request.getParameter("fname"));
            stmt.setString(3, request.getParameter("lname"));
            stmt.setString(4, request.getParameter("email"));
            stmt.setString(5, request.getParameter("password"));
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            PrintWriter out = response.getWriter();
            
            out.println("Successfully Inserted");
		}
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
            
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
