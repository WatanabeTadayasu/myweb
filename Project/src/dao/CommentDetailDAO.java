package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import base.DBManager;
import beans.CommentDataBeans;
import beans.CommentDetailDataBeans;

public class CommentDetailDAO {

	/**
	 * 購入詳細登録処理
	 * @param bddb BuyDetailDataBeans
	 * @throws SQLException
	 * 			呼び出し元にスローさせるため
	 */
	public static void insertCommentDetail(CommentDetailDataBeans cddb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO t_thread_detail(thread_id,comment_id) VALUES(?,?)");
			st.setInt(1, cddb.getThreadId());
			st.setInt(2, cddb.getCommentId());
			st.executeUpdate();
			System.out.println("inserting BuyDetail has been completed");

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
     * 購入IDによる購入詳細情報検索
     * @param buyId
     * @return buyDetailItemList ArrayList<ItemDataBeans>
     *             購入詳細情報のデータを持つJavaBeansのリスト
     * @throws SQLException
     */
	public static ArrayList<CommentDataBeans> getCommentDataBeansListByBuyId(int threadId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM m_comment WHERE thread_id = ?");
			st.setInt(1, threadId);

			ResultSet rs = st.executeQuery();
			ArrayList<CommentDataBeans> commentDataList = new ArrayList<CommentDataBeans>();

			while (rs.next()) {
				CommentDataBeans cdb = new CommentDataBeans();
				cdb.setId(rs.getInt("id"));
				cdb.setThreadId(rs.getInt("thread_id"));
				cdb.setUserLoginId(rs.getString("name"));
				cdb.setComment(rs.getString("m_comment"));
//				cdb.setCreateDate(rs.getString("create_date"));

				/* Date型⇒String型 */
				// 変換後の日付文字列の書式を指定
				DateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
				// 変換
				String sDate = df1.format(rs.getTimestamp("create_date"));
				//bdb.setBuyDate(sDate);

				//bdb.setBuyDate(rs.getTimestamp("create_date"));

				cdb.setCreateDate(sDate);

				commentDataList.add(cdb);
			}

			System.out.println("searching ItemDataBeansList by BuyID has been completed");
			return commentDataList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
