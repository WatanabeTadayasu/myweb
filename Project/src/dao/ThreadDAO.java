package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ThreadDataBeans;

public class ThreadDAO {



	/**
	 * ランダムで引数指定分のItemDataBeansを取得
	 * @param limit 取得したいかず
	 * @return <ItemDataBeans>
	 * @throws SQLException
	 */
	public static ArrayList<ThreadDataBeans> getRandItem(int limit) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM t_thread ORDER BY RAND() LIMIT ? ");
			st.setInt(1, limit);

			ResultSet rs = st.executeQuery();

			ArrayList<ThreadDataBeans> itemList = new ArrayList<ThreadDataBeans>();

			while (rs.next()) {
				ThreadDataBeans item = new ThreadDataBeans();
				item.setId((int)rs.getInt("id"));
				item.setUserLoginId(rs.getString("user_login_id"));
				item.setThreadTitle(rs.getString("thread_title"));
				item.setThreadText(rs.getString("thread_text"));
				item.setThreadCategoryId(rs.getInt("thread_category_id"));
				item.setCreateDate(rs.getString("create_date"));
				itemList.add(item);
			}
			System.out.println("getAllItem completed");
			return itemList;
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
	 * 商品IDによる商品検索
	 * @param itemId
	 * @return ItemDataBeans
	 * @throws SQLException
	 */
	public static ThreadDataBeans getThreadByThreadID(int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM t_thread WHERE id = ?");
			st.setInt(1, itemId);

			ResultSet rs = st.executeQuery();

			ThreadDataBeans item = new ThreadDataBeans();
			if (rs.next()) {
				item.setId(rs.getInt("id"));
				item.setUserLoginId(rs.getString("user_login_id"));
				item.setThreadTitle(rs.getString("thread_title"));
				item.setThreadText(rs.getString("thread_text"));
				item.setThreadCategoryId(rs.getInt("thread_category_id"));
				item.setCreateDate(rs.getString("create_date"));
			}

			System.out.println("searching item by itemID has been completed");

			return item;
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
	 * 商品検索
	 * @param searchWord
	 * @param pageNum
	 * @param pageMaxItemCount
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ThreadDataBeans> getItemsByItemName(String searchWord, int pageNum, int pageMaxItemCount) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			int startiItemNum = (pageNum - 1) * pageMaxItemCount;
			con = DBManager.getConnection();

			if (searchWord.length() == 0) {
				// 全検索
				st = con.prepareStatement("SELECT * FROM m_item ORDER BY id ASC LIMIT ?,? ");
				st.setInt(1, startiItemNum);
				st.setInt(2, pageMaxItemCount);

			} else {
				// 商品名検索
				st = con.prepareStatement("SELECT * FROM m_item WHERE name like ? ORDER BY id ASC LIMIT ?,? ");
				st.setString(1,"%" + searchWord + "%");
				st.setInt(2, startiItemNum);
				st.setInt(3, pageMaxItemCount);
			}

			ResultSet rs = st.executeQuery();
			ArrayList<ThreadDataBeans> itemList = new ArrayList<ThreadDataBeans>();

			while (rs.next()) {
				ThreadDataBeans item = new ThreadDataBeans();
				item.setId(rs.getInt("id"));
				item.setUserLoginId(rs.getString("user_login_id"));
				item.setThreadTitle(rs.getString("thread_title"));
				item.setThreadText(rs.getString("thread_text"));
				item.setThreadCategoryId(rs.getInt("thread_category_id"));
				item.setCreateDate(rs.getString("create_date"));
			}
			System.out.println("get Items by itemName has been completed");
			return itemList;
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
	public static double getItemCount(String searchWord) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("select count(*) as cnt from m_item where name like ?");
			st.setString(1, "%" + searchWord + "%");
			ResultSet rs = st.executeQuery();
			double coung = 0.0;
			while (rs.next()) {
				coung = Double.parseDouble(rs.getString("cnt"));
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

}
