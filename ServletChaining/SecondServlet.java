package org.btm.forwardApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String pname=(String)req.getAttribute("prdnm");
		String pqty=(String)req.getAttribute("prdqt");
		int qty=Integer.parseInt(pqty);
		double price=40000.00;
		double totalsum=(price*qty); //BUSINESS LOGIC//
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
				+ "<h1>Product Details are "+pname+" "+totalsum+"</h1>"
						+ "</body></html>"); // PRESENTATION LOGIC//
		out.flush();
		out.close();
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into muzeeb.mobiles values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=muzeeb");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, pname);
			pstmt.setInt(2, qty);
			pstmt.setDouble(3, totalsum);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
