package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import base.DBManager;
import beans.PostDataBeans;

/**
 *
 * @author d-yamaguchi
 *
 */
public class PostDAO {

	/**
	 * 購入情報登録処理
	 * @param bdb 購入情報
	 * @return
	 * @throws SQLException 呼び出し元にスローさせるため
	 */
	public static int insertBuy(PostDataBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO t_thread(user_login_id,thread_title,thread_text,thread_category_id,create_date) VALUES (?,?,?,?,now())"
					 , Statement.RETURN_GENERATED_KEYS);
			st.setString(1, bdb.getUserId());
			st.setString(2, bdb.getThreadTitle());
			st.setString(3, bdb.getThreadText());
			st.setInt(4, bdb.getThreadCategoryId());
			//st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			System.out.println("inserting buy-datas has been completed");

			return autoIncKey;
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
	 * 購入IDによる購入情報検索
	 * @param buyId
	 * @return BuyDataBeans
	 * 				購入情報のデータを持つJavaBeansのリスト
	 * @throws SQLException
	 * 				呼び出し元にスローさせるため
	 */
	public static  PostDataBeans getBuyDataBeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_thread"
							+ " JOIN m_thread_category"
							+ " ON t_thread.thread_category_id = m_thread_category.id"
							+ " WHERE t_thread.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();

			PostDataBeans bdb = new PostDataBeans();
			if (rs.next()) {
				bdb.setId(rs.getInt("id"));
				bdb.setUserId(rs.getString("user_login_id"));
				bdb.setThreadTitle(rs.getString("thread_title"));
				bdb.setThreadText(rs.getString("thread_text"));
				bdb.setThreadCategoryId(rs.getInt("thread_category_id"));
				bdb.setThreadCategoryName(rs.getString("name"));
				//bdb.setBuyDate(rs.getTimestamp("create_date"));

				/* Date型⇒String型 */
				// 変換後の日付文字列の書式を指定
				DateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
				// 変換
				String sDate = df1.format(rs.getTimestamp("create_date"));
				//bdb.setBuyDate(sDate);

				//bdb.setBuyDate(rs.getTimestamp("create_date"));

				bdb.setCreateDate(sDate);

			}

			System.out.println("searching BuyDataBeans by buyID has been completed");

			return bdb;
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
	 * 購入IDによる購入履歴情報検索
	 * @param buyId
	 * @return BuyDataBeans
	 * 				購入情報のデータを持つJavaBeansのリスト
	 * @throws SQLException
	 * 				呼び出し元にスローさせるため
	 */
	public static ArrayList<PostDataBeans> getBuyDataBeansHistory(String loginId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_thread"
							+ " JOIN m_thread_category"
							+ " ON t_thread.thread_category_id = m_thread_category.id"
							+ " WHERE user_login_id = ?"
							+ " order by t_thread.id desc");
			st.setString(1, loginId);

			ResultSet rs = st.executeQuery();

			ArrayList<PostDataBeans> buyDataBeansList = new ArrayList<PostDataBeans>();

			while (rs.next()) {
				PostDataBeans bdb = new PostDataBeans();
				bdb.setId(rs.getInt("id"));
				bdb.setUserId(rs.getString("user_login_id"));
				bdb.setThreadTitle(rs.getString("thread_title"));
				bdb.setThreadText(rs.getString("thread_text"));
				bdb.setThreadCategoryId(rs.getInt("thread_category_id"));
				bdb.setThreadCategoryName(rs.getString("name"));

				//bdb.setBuyDate(rs.getTimestamp("create_date"));

				/* Date型⇒String型 */
				// 変換後の日付文字列の書式を指定
				DateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
				// 変換
				String sDate = df1.format(rs.getTimestamp("create_date"));
				//bdb.setBuyDate(sDate);

				//bdb.setBuyDate(rs.getTimestamp("create_date"));

				bdb.setCreateDate(sDate);

				buyDataBeansList.add(bdb);

			}

			System.out.println("searching BuyDataBeans by buyID has been completed");

			return buyDataBeansList;
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
