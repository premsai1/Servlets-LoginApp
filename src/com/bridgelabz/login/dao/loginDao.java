package com.bridgelabz.login.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author : Premsai Manthani
 * @purpose : This class maintains all the database 
 * related operations such update,add,insert functionalities.
 */

public class LoginDao {

	static String url = "jdbc:mysql://localhost:3306/prem";
	static String unames = "root";
	static String passs = "root";

	public boolean check(String uname, String pass) {
		try {
			String sql = "select * from regestration where username=? and password=?";
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = (Connection) DriverManager.getConnection(url, unames, passs);
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		return false;
	}

	public boolean recover(String uname, String mail) {
		try {

			String sql = "select * from regestration where username = ? and mail = ?";
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = (Connection) DriverManager.getConnection(url, unames, passs);
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, mail);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		return false;
	}

	public void add(String first_name, String username, String password, String address, String contact, String mail) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, unames, passs);
			PreparedStatement pst = (PreparedStatement) con
					.prepareStatement("insert into regestration values(?,?,?,?,?,?)");
			pst.setString(1, first_name);
			pst.setString(2, username);
			pst.setString(3, password);
			pst.setString(4, address);
			pst.setString(5, contact);
			pst.setString(6, mail);
			int count = pst.executeUpdate();
			System.out.println("rows affected " + count);
		} catch (Exception e) {
			System.out.println("Error in add " + e);
		}

	}

	public void reset(String news, String mail) {
		try {
			System.out.println(" i am mail" + mail);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, unames, passs);
			PreparedStatement pst = (PreparedStatement) con
					.prepareStatement("update regestration  set password =? where mail= ? ");
			System.out.println("i am comoing");
			pst.setString(1, news);
			pst.setString(2, mail);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error in add " + e);
		}
	}

	public boolean duplicate(String mail) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, unames, passs);
			PreparedStatement pst = (PreparedStatement) con
					.prepareStatement(" select * from regestration where mail=? ");
			pst.setString(1, mail);
			ResultSet rs = pst.executeQuery();
			String mailC;
			if (rs.next()) {
				mailC = rs.getString("mail");
				if (mailC.equals(mail)) {
					return true;
				}
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error in add " + e);
		}

		return false;

	}

}
