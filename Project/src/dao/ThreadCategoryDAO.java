package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ThreadCategoryDataBeans;

/**
 *
 * @author d-yamaguchi
 *
 */
public class ThreadCategoryDAO {

	/**
	 * DBに登録されている配送方法を取得
	 * @return {DeliveryMethodDataBeans}
	 * @throws SQLException
	 */
	public static ArrayList<ThreadCategoryDataBeans> getAllThreadCategoryDataBeans() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM m_thread_category");

			ResultSet rs = st.executeQuery();

			ArrayList<ThreadCategoryDataBeans> threadCategoryDataBeansList = new ArrayList<ThreadCategoryDataBeans>();
			while (rs.next()) {
				ThreadCategoryDataBeans tcdb = new ThreadCategoryDataBeans();
				tcdb.setId(rs.getInt("id"));
				tcdb.setName(rs.getString("name"));
//				dmdb.setPrice(rs.getInt("price"));

				threadCategoryDataBeansList.add(tcdb);
			}

			System.out.println("searching all DeliveryMethodDataBeans has been completed");

			return threadCategoryDataBeansList;
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
	 * 配送方法をIDをもとに取得
	 * @param DeliveryMethodId
	 * @return DeliveryMethodDataBeans
	 * @throws SQLException
	 */
	public static ThreadCategoryDataBeans getThreadCategoryDataBeansByID(int inputThreadCategoryId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM m_thread_category WHERE id = ?");
			st.setInt(1, inputThreadCategoryId);

			ResultSet rs = st.executeQuery();

			ThreadCategoryDataBeans tcdb = new ThreadCategoryDataBeans();
			if (rs.next()) {

			tcdb.setId(rs.getInt("id"));
			tcdb.setName(rs.getString("name"));
//			dmdb.setPrice(rs.getInt("price"));

			}

			System.out.println("searching DeliveryMethodDataBeans by DeliveryMethodID has been completed");

			return tcdb;

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
//     *購入IDによる配送方法検索
//     * @param buyId
//     * @return dmdb DeliveryMethodDataBeans
//     *             配送方法の情報に対応するデータを持つJavaBeans
//     * @throws SQLException
//     */
//	public static ThreadCategoryDataBeans getThreadCategoryDataBeansByBuyId(int buyId) throws SQLException {
//		Connection con = null;
//		PreparedStatement st = null;
//		try {
//			con = DBManager.getConnection();
//
//			st = con.prepareStatement(
//					"SELECT m_thread_category.name"
////					+ " m_delivery_method.price"
//					+ " FROM t_thread"
//					+ " JOIN m_thread_category"
//					+ " ON m_thread_category.id = t_thread.thread_category_id"
//					+ " WHERE t_thread.id = ?");
//			st.setInt(1, buyId);
//
//			ResultSet rs = st.executeQuery();
//			ThreadCategoryDataBeans tcdb = new ThreadCategoryDataBeans();
//
//			while (rs.next()) {
//				tcdb.setName(rs.getString("name"));
////				dmdb.setPrice(rs.getInt("m_delivery_method.price"));
//
//			}
//
//			System.out.println("searching DeliveryMethodDataBeans by BuyID has been completed");
//			return tcdb;
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			throw new SQLException(e);
//		} finally {
//			if (con != null) {
//				con.close();
//			}
//		}
//	}
}
