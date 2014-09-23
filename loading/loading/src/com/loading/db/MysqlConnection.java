package com.loading.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cmtest";
		try {
			Class.forName("com.mysql.jdbc.Driver");                                                    //¼ÓÔØÇý¶¯
			try {
				conn = DriverManager.getConnection(url, "root", "m459484921");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Success");
		return conn;
	}
}
