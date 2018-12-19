package cn.hnck.com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcPoolUtils {
	private static DataSource dataSource = new ComboPooledDataSource();

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void close(ResultSet rs, Statement pstmt, Connection con)
			throws SQLException {
		try {
			if (rs != null)
				rs.close();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
	}

	public static int dbCUD(String sql, Object... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			con = JdbcPoolUtils.getConnection();
			pstmt = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			row = pstmt.executeUpdate();
			JdbcPoolUtils.close(null, pstmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public static ResultSet query(Connection con, String sql, Object... params) {
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
