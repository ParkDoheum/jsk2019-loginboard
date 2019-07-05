package kr.hkit.loginboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.hkit.loginboard.vo.UserVO;

public class UserDAO {
	
	//int (i_user값 (-1)비밀번호 틀림 (0)id가 없음, (0 >) 제대로 된 것)
	public static int login(String id, String pw) {
		int i_user = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT i_user, pw FROM t_user WHERE id = ? ";
		
		try {
			con = CommonDAO.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id.trim());			
			
			rs = ps.executeQuery();
			while(rs.next()) {				
				String dbpw = rs.getString("pw");
				if(dbpw.equals(pw)) {
					i_user = rs.getInt("i_user");	
				} else {
					i_user = -1; 
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
		} finally {
			CommonDAO.close(con, ps, rs);
		}		
		return i_user;
	}
	
	public static int joinMember(UserVO vo) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_user (i_user, id, pw, nm) "
				+ " VALUES (seq_user.nextVal, ?, ?, ?) ";
		
		try {
			con = CommonDAO.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId().trim());
			ps.setString(2, vo.getPw().trim());
			ps.setString(3, vo.getNm().trim());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {		
			e.printStackTrace();			
		} finally {
			CommonDAO.close(con, ps, null);
		}
		
		return result;
	}
}






