package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ThreadDataBeans;
import beans.ThreadDetailDataBeans;

public class ThreadDetailDAO {

	/**
	 * 購入詳細登録処理
	 * @param bddb BuyDetailDataBeans
	 * @throws SQLException
	 * 			呼び出し元にスローさせるため
	 */
	public static void insertThreadDetail(ThreadDetailDataBeans bddb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO t_thread_detail(thread_id,comment_id) VALUES(?,?)");
			st.setInt(1, bddb.getThreadId());
			st.setInt(2, bddb.getCommentId());
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

//	/**
//	 * 購入IDによる購入情報検索
//	 * @param buyId
//	 * @return {BuyDataDetailBeans}
//	 * @throws SQLException
//	 */
//	public ArrayList<ThreadDetailDataBeans> getBuyDataBeansListByBuyId(int buyId) throws SQLException {
//		Connection con = null;
//		PreparedStatement st = null;
//		try {
//			con = DBManager.getConnection();
//
//			st = con.prepareStatement("SELECT * FROM t_buy_detail WHERE buy_id = ?");
//			st.setInt(1, buyId);
//
//			ResultSet rs = st.executeQuery();
//			ArrayList<ThreadDetailDataBeans> buyDetailList = new ArrayList<ThreadDetailDataBeans>();
//
//			while (rs.next()) {
//				ThreadDetailDataBeans bddb = new ThreadDetailDataBeans();
//				bddb.setId(rs.getInt("id"));
//				bddb.setThreadId(rs.getInt("buy_id"));
//				bddb.setCommentId(rs.getInt("item_id"));
//				buyDetailList.add(bddb);
//			}
//
//			System.out.println("searching BuyDataBeansList by BuyID has been completed");
//			return buyDetailList;
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			throw new SQLException(e);
//		} finally {
//			if (con != null) {
//				con.close();
//			}
//		}
//	}

	 /**
     * 購入IDによる購入詳細情報検索
     * @param buyId
     * @return buyDetailItemList ArrayList<ItemDataBeans>
     *             購入詳細情報のデータを持つJavaBeansのリスト
     * @throws SQLException
     */
	public static ArrayList<ThreadDataBeans> getItemDataBeansListByBuyId(int threadId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT id,thread_id,name,m_comment,create_date,FROM m_comment"
					+ " WHERE thread_id = ?");
			st.setInt(1, threadId);

			ResultSet rs = st.executeQuery();
			ArrayList<ThreadDataBeans> buyDetailItemList = new ArrayList<ThreadDataBeans>();

			while (rs.next()) {
				ThreadDataBeans idb = new ThreadDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setUserLoginId(rs.getString("user_login_id"));
				idb.setThreadTitle(rs.getString("thread_title"));
				idb.setThreadText(rs.getString("thread_text"));
				idb.setThreadCategoryId(rs.getInt("thread_category_id"));
				idb.setCreateDate(rs.getString("create_date"));

				buyDetailItemList.add(idb);
			}

			System.out.println("searching ItemDataBeansList by BuyID has been completed");
			return buyDetailItemList;
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
	public static ArrayList<ThreadDataBeans> getItemDataBeansHistoryByBuyId() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT m_item.id,"
					+ " m_item.name,"
					+ " m_item.price"
					+ " FROM t_buy_detail"
					+ " JOIN m_item"
					+ " ON t_buy_detail.item_id = m_item.id");

			ResultSet rs = st.executeQuery();

			ArrayList<ThreadDataBeans> buyDetailItemList = new ArrayList<ThreadDataBeans>();

			while (rs.next()) {
				ThreadDataBeans idb = new ThreadDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setUserLoginId(rs.getString("user_login_id"));
				idb.setThreadTitle(rs.getString("thread_title"));
				idb.setThreadText(rs.getString("thread_text"));
				idb.setThreadCategoryId(rs.getInt("thread_category_id"));
				idb.setCreateDate(rs.getString("create_date"));
				buyDetailItemList.add(idb);
			}

			System.out.println("searching ItemDataBeansList by BuyID has been completed");
			return buyDetailItemList;
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
