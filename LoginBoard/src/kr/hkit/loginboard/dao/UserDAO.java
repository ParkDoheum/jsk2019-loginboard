package kr.hkit.loginboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.hkit.loginboard.vo.UserVO;

public class UserDAO {
	public static int joinMember(UserVO vo) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_user (i_user, id, pw, nm) "
				+ " VALUES (seq_user.nextVal, ?, ?, ?) ";
		
		try {
			con = CommonDAO.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPw());
			ps.setString(3, vo.getNm());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {		
			e.printStackTrace();			
		} finally {
			CommonDAO.close(con, ps, null);
		}
		
		return result;
	}
}






