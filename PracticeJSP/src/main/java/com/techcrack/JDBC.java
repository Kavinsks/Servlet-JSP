package com.techcrack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	private Connection con=null;
	public boolean dataBaseConnect(String name,int age) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","KavinDharani@3");
			System.out.println("Data Base Has Been Created !!!");
			writeData(name,age);
			return true;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	private void writeData(String name,int age) throws Exception{
		//String preQuery="INSERT INTO voter_table VALUES(?,?)";
//		PreparedStatement ps=con.prepareStatement(preQuery);
		String query="INSERT INTO voter_table VALUES('"+name+"',"+age+")";
		Statement st=con.createStatement();
		//st.executeUpdate("CREATE TABLE voter_table(name VARCHAR(20),age INT)");
		System.out.println(st.executeUpdate(query)+" rows/affected");
//		ps.setInt(2,age);
//		ps.setString(1,name);
//		ps.executeUpdate();
	}
}
