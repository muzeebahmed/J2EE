package org.btm.cookieApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		
		//CREATE COOKIE OBJECT//
		
		Cookie ck=new Cookie("nmg",name);
		
		//SET THE AGE FOR COOKIE//
		ck.setMaxAge(600);//+ve integer value is PERSISANT COOKIE and -ve integer value is NON-PERSISTANT COOKIE//
		
		//ADD COOKIE TO RESPONSE HEADER if not response will won't get back to the client//
		resp.addCookie(ck);
		
		PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<form action='ss'>");
		out.print("<input type='submit' value=NextSession'>" );
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		out.flush();
		out.close();
	}
}
