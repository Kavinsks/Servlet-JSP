package com.techcrack;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
	  int num=Integer.parseInt(req.getParameter("num1"));
	  int numm=Integer.parseInt(req.getParameter("num2"));
	  int result=num+numm;
	  res.getWriter().println("The Addition is  : "+result);
	}
}
