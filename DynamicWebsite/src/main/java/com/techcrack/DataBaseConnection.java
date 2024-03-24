package com.techcrack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.SQLException;

public class DataBaseConnection {
	private String userName=null;
	private String passWord=null;
	private Connection con=null;
	private Statement st=null;
	private String URL="jdbc:mysql://localhost:3306/music";
	public DataBaseConnection(String userName,String passWord) throws ClassNotFoundException,SQLException{
		this.userName=userName;
		this.passWord=passWord;
		startTheConnection();
	}
	private void startTheConnection() throws ClassNotFoundException,SQLException{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL,userName,passWord);
			st=con.createStatement();
			System.out.println("Data Base Has Been Successfully Connected!!");
	}
	public ResultSet dataFromDataBase(String s) throws SQLException {
		return st.executeQuery(s);
	}
	public boolean createTable(String s) throws SQLException {
		st.executeUpdate(s);
		System.out.println("Table has Been created Successfully..");
		return true;
	}
	public boolean updateTable(String s) throws SQLException {
		st.executeUpdate(s);
		System.out.println("Update Hass Succesfull...");
		return true;
	}
	public static void main(String[] args) throws SQLException {
		try {
			DataBaseConnection dsc=new DataBaseConnection("root","KavinDharani@3");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
	}
}

