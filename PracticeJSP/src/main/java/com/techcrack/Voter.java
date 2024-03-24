package com.techcrack;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class Voter extends HttpServlet{
	public void service(HttpServletRequest rs,HttpServletResponse re) {
		String name=rs.getParameter("name");
		int age=Integer.parseInt(rs.getParameter("age"));
		PrintWriter pw=null;
		try {
			pw = re.getWriter();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		if(age>=18) {
			JDBC db=new JDBC();
			db.dataBaseConnect(name, age);
			pw.println("Your Are Eligible For Voting !!!!");
		}
		else {
//			RequestDispatcher rd=rs.getRequestDispatcher("no-vote");
//			rs.setAttribute("kk",age+"");
//			try {
//				rd.forward(rs, re);
//			} catch (ServletException | IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				re.sendRedirect("no-vote?age="+age);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			ServletContext hss=getServletContext();
			try {
//				Cookie cookie=new Cookie("age",age+"");
//				re.addCookie(cookie);
				HttpSession hs=rs.getSession();
				hs.setAttribute("age", age);
				System.out.println(" COnsole Servlet Context : "+hss.getInitParameter("Value"));
				re.sendRedirect("no-vote");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
