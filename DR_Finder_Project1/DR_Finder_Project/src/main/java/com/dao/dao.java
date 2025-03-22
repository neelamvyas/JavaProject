package com.dao;
// For database connectivity

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.model;
import com.mysql.jdbc.Connection;

public class dao {
   public static Connection getconnect()
   {
	   Connection con = null;
	   try 
	   {
		Class.forName("com.mysql.jdbc.Driver");
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor_finder","root","");
	   } 
	   catch (Exception e) 
	   {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   
	   return con;
	   
   }
   
   //Fetching data to database
   
   public static int savedata(model m)
   {
	   int status =0 ;
	   Connection con = dao.getconnect();
	   
	   try {
		PreparedStatement ps = con.prepareStatement("insert into Signup (name, surname, phone, email, gender, pwd, cpwd) values(?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, m.getName());
		ps.setString(2, m.getSurname());
		ps.setString(3, m.getPhone());
		ps.setString(4, m.getEmail());
		ps.setString(5, m.getGender());
		ps.setString(6, m.getPwd());
		ps.setString(7, m.getCpwd());
		
		status = ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return status;
   }
}
