package kr.hkit.loginboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.hkit.loginboard.vo.BoardVO;

public class BoardDAO {
	public static List<BoardVO> selectListBoard() {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.i_board, A.title, A.rdate, B.nm as user_nm"
				+ " FROM t_board A INNER JOIN t_user B"
				+ " ON A.i_user = B.i_user "
				+ " ORDER BY A.i_board DESC ";
		
		try {
			con = CommonDAO.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setI_board(rs.getInt("i_board"));
				vo.setTitle(rs.getString("title"));
				vo.setRdate(rs.getString("rdate"));
				vo.setUser_nm(rs.getString("user_nm"));
				
				list.add(vo);
			}
			
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		} finally {
			CommonDAO.close(con, ps, rs);
		}
		
		return list;
	}
	
	//글등록
	public static int insertBoard(BoardVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (i_board, title, content, i_user)"
				+ " VALUES (seq_board.nextVal, ?, ?, ?) ";
		
		try {			
			con = CommonDAO.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getI_user());
			result = ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			CommonDAO.close(con, ps, null);
		}
		return result;
	}
}
