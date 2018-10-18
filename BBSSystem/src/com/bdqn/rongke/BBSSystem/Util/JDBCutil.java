package com.bdqn.rongke.BBSSystem.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCutil {
		//链接路劲常量
		private static final String url="jdbc:mysql://localhost/bbssystem?characterEncoding=utf8";
		//用户名
		private static final String user="root";
		//密码
		private static final String password="123456";
		//获取链接
		Connection conn;
		//预编译
		PreparedStatement pst;
		//处理结果
		ResultSet rs;
		//静态代码块
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	 	public static Connection getConnection() throws SQLException {
	 		return DriverManager.getConnection(url, user, password);
	 
	 	}
	 	public static void free(Connection conn,Statement st2,ResultSet rs) throws SQLException {
	 		if(conn!=null) {
	 			conn.close();
	 		}
	 		if(st2!=null) {
	 			st2.close();
	 		}
	 		if(rs!=null) {
	 			rs.close();
	 		}
	 	}
}
