package kr.hkit.loginboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonDAO {
	private static final String DRIVE = "oracle.jdbc.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String ID = "loginboard";
	private static final String PW = "hkit2019";
	
	public static Connection getCon() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVE);
		Connection con = DriverManager.getConnection(DB_URL, ID, PW);
		System.out.println("DB 연결!!");
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) { rs.close(); }			
		} catch (SQLException e) {e.printStackTrace();}
		
		try {
			if(ps != null) { ps.close(); }			
		} catch (SQLException e) {e.printStackTrace();}
		
		try {
			if(con != null) { con.close(); }			
		} catch (SQLException e) {e.printStackTrace();}
	}
}
