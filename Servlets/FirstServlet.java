package org.btm.lifecycleApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet
{
	public FirstServlet()
	{
		System.out.println("Servlet object created");
	}
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("Servlet object is instantiated");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		String branch=req.getParameter("br");
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='red'>"
				+ "<h1> Hi "+name+" ur "+branch+"</h1>"
						+ "</body></html>");
		out.flush();
		out.close();
		System.out.println("service() executed");
	}
	@Override
	public void destroy()
	{
		System.out.println("close all the costly resources");
	}
}
