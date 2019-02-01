package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.ThreadRecordBeans;

/**
*
* @author d-yamaguchi
*
*/
public class ThreadRecordDAO {

	/**
	 * データの挿入処理を行う。現在時刻は挿入直前に生成
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void insertRecord(ThreadRecordBeans trb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO t_thread_record(user_id,thread_id) VALUES (?,?)");
			st.setInt(1, trb.getUserId());
			st.setInt(2, trb.getThreadId());
			st.executeUpdate();
			System.out.println("inserting record has been completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 商品総数を取得
	 *
	 * @param searchWord
	 * @return
	 * @throws SQLException
	 */
	public static int getItemCount(int threadId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("select count(*) as cnt from t_thread_record where thread_id = ?");
			st.setInt(1, threadId);
			ResultSet rs = st.executeQuery();
			int coung = 0;
			while (rs.next()) {
				coung = Integer.parseInt(rs.getString("cnt"));
			}
			return coung;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * userIdの重複チェック
	 * @return bool 重複している
	 * @throws SQLException
	 */
	public static boolean isOverlapUserId(int userId, int threadId) throws SQLException {
		// 重複しているかどうか表す変数
		boolean isOverlap = false;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			// 入力されたlogin_idが存在するか調べる
			st = con.prepareStatement("SELECT user_id FROM t_thread_record WHERE user_id = ? AND thread_id = ?");
			st.setInt(1, userId);
			st.setInt(2, threadId);
			ResultSet rs = st.executeQuery();

			System.out.println("searching userId by inputUserId has been completed");

			if (rs.next()) {
				isOverlap = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("overlap check has been completed");
		return isOverlap;
	}

}
