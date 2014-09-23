package com.loading.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.loading.bean.User;
import com.loading.db.MysqlConnection;

public class Dao {
	public boolean login(User user) throws SQLException {
		Connection conn = MysqlConnection.getConnection();
		String sql = "select *from test1 where username=? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();                                    //返回结果集
		if (rs.next()) {
			rs.close();
			pstmt.close();
			conn.close();
			return true;
		} else {
			rs.close();
			pstmt.close();
			conn.close();
			return false;
		}
	}

	public boolean register(User user) throws SQLException {
		Connection conn = MysqlConnection.getConnection();
		String sql = "select *from test1 where username=?";
		String sql2 = "insert into test1(username,password) value(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt.setString(1, user.getUsername());
		pstmt2.setString(1, user.getUsername());
		pstmt2.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			rs.close();
			pstmt.close();                                                               //数据库游标
			pstmt2.close();
			conn.close();
			return false;
		} else {
			pstmt2.executeUpdate();
			rs.close();
			pstmt.close();
			pstmt2.close();
			conn.close();
			return true;
		}

	}
}
