package com.techcrack;

import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogInUser extends HttpServlet {
	public LogInUser() {
		super();
	}
	public void doPost(HttpServletRequest rq,HttpServletResponse rs) {
		PrintWriter pw=null;
		try {
			pw=rs.getWriter();
			String userName=rq.getParameter("userName");
			String passWord=rq.getParameter("passWord");
			DataBaseConnection dbc=new DataBaseConnection("root","KavinDharani@3");
			ResultSet rs1=dbc.dataFromDataBase("SELECT userName,passWord FROM userData");
			while(rs1.next()) {
				if(rs1.getString(1).equals(userName)) {
					if(rs1.getString(2).equals(passWord)) {
						pw.println("Login Success Fully");
					}
					else {
						pw.println("Wrong PassWord!!!");
					}
					return;
				}
			}
			System.out.println("Invalid User Id..");
		}
		catch(Exception e) {
			pw.println("Something Unsual Check the Details Again!!");
		}
	}

}
