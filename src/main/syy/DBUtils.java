<<<<<<< HEAD
package com.lanou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/people?useUnicode=true&useSSL=false&characterEncoding=utf8";
	System.err.println("11111");
	Connection con = null;
	ResultSet res = null;

	public void DataBase() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			System.err.println("×°ï¿½ï¿½ JDBC/ODBC ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ê§ï¿½Ü¡ï¿½");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("ï¿½Ş·ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½İ¿ï¿½");
			e.printStackTrace();
		}
	}

	// ï¿½ï¿½Ñ¯
	public ResultSet Search(String sql, String str[]) {
		DataBase();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			res = pst.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	// ï¿½ï¿½É¾ï¿½Ş¸ï¿½
	public int AddU(String sql, String str[]) {
		int a = 0;
		DataBase();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			a = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

}
=======
package com.lanou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/people?useUnicode=true&useSSL=false&characterEncoding=utf8";

	Connection con = null;
	ResultSet res = null;

	public void DataBase() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			System.err.println("×°ÔØ JDBC/ODBC Çı¶¯³ÌĞòÊ§°Ü¡£");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("ÎŞ·¨Á¬½ÓÊı¾İ¿â");
			e.printStackTrace();
		}
	}

	// ²éÑ¯
	public ResultSet Search(String sql, String str[]) {
		DataBase();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			res = pst.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	// ÔöÉ¾ĞŞ¸Ä
	public int AddU(String sql, String str[]) {
		int a = 0;
		DataBase();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			a = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

}
>>>>>>> 04569640572dfead19e473432ef9b9b27362ba8b
