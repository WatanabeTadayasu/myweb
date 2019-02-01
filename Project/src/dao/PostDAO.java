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
			st.setString(1, bdb.getUserLoginId());
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
	public static PostDataBeans getThreadDataBeansByBuyId(int buyId) throws SQLException {
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
				bdb.setUserLoginId(rs.getString("user_login_id"));
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
	public static ArrayList<PostDataBeans> getThreadDataBeansHistory(String loginId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_thread"
							+ " JOIN m_thread_category"
							+ " ON t_thread.thread_category_id = m_thread_category.id"
							+ " WHERE user_login_id = ?"
							+ " order by t_thread.id ASC");
			st.setString(1, loginId);

			ResultSet rs = st.executeQuery();

			ArrayList<PostDataBeans> buyDataBeansList = new ArrayList<PostDataBeans>();

			while (rs.next()) {
				PostDataBeans bdb = new PostDataBeans();
				bdb.setId(rs.getInt("id"));
				bdb.setUserLoginId(rs.getString("user_login_id"));
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

	//投稿削除

    public static void postdeletemethod(int cartInItem) {
		// TODO 自動生成されたメソッド・スタブ
    	Connection conn = null;
    	try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "DELETE FROM t_thread WHERE ID = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);

            conn.setAutoCommit(false);

            pStmt.setInt(1, cartInItem);

            int rs = pStmt.executeUpdate();

            System.out.println(rs + "行が削除されました。");

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            return;

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

    }

    /**
	 * ランダムで引数指定分のItemDataBeansを取得
	 * @param limit 取得したいかず
	 * @return <ItemDataBeans>
	 * @throws SQLException
	 */
	public static ArrayList<PostDataBeans> getRandThread(int limit) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM t_thread ORDER BY RAND() LIMIT ? ");
			st.setInt(1, limit);

			ResultSet rs = st.executeQuery();

			ArrayList<PostDataBeans> postList = new ArrayList<PostDataBeans>();

			while (rs.next()) {
				PostDataBeans post = new PostDataBeans();
				post.setId((int)rs.getInt("id"));
				post.setUserLoginId(rs.getString("user_login_id"));
				post.setThreadTitle(rs.getString("thread_title"));
				post.setThreadText(rs.getString("thread_text"));
				post.setThreadCategoryId(rs.getInt("thread_category_id"));
//				item.setCreateDate(rs.getString("create_date"));

				/* Date型⇒String型 */
				// 変換後の日付文字列の書式を指定
				DateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
				// 変換
				String sDate = df1.format(rs.getTimestamp("create_date"));
				//bdb.setBuyDate(sDate);

				//bdb.setBuyDate(rs.getTimestamp("create_date"));

				post.setCreateDate(sDate);

				postList.add(post);
			}
			System.out.println("getAllItem completed");
			return postList;
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
	 * idの降順で引数指定分のItemDataBeansを取得
	 * @param limit 取得したいかず
	 * @return <ItemDataBeans>
	 * @throws SQLException
	 */
		public static ArrayList<PostDataBeans> getQuickThread(int limit) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			try {
				con = DBManager.getConnection();

				st = con.prepareStatement("SELECT * FROM t_thread ORDER BY id DESC LIMIT ? ");
				st.setInt(1, limit);

				ResultSet rs = st.executeQuery();

				ArrayList<PostDataBeans> postList = new ArrayList<PostDataBeans>();

				while (rs.next()) {
					PostDataBeans post = new PostDataBeans();
					post.setId((int)rs.getInt("id"));
					post.setUserLoginId(rs.getString("user_login_id"));
					post.setThreadTitle(rs.getString("thread_title"));
					post.setThreadText(rs.getString("thread_text"));
					post.setThreadCategoryId(rs.getInt("thread_category_id"));
//					item.setCreateDate(rs.getString("create_date"));

					/* Date型⇒String型 */
					// 変換後の日付文字列の書式を指定
					DateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
					// 変換
					String sDate = df1.format(rs.getTimestamp("create_date"));
					//bdb.setBuyDate(sDate);

					//bdb.setBuyDate(rs.getTimestamp("create_date"));

					post.setCreateDate(sDate);

					postList.add(post);
				}
				System.out.println("getAllItem completed");
				return postList;
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
		 * カテゴリID検索
		 * @param searchWord
		 * @param pageNum
		 * @param pageMaxItemCount
		 * @return
		 * @throws SQLException
		 */
		public static ArrayList<PostDataBeans> getItemsByCategoryId(int categoryId, int pageNum, int pageMaxItemCount) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			try {
				int startiItemNum = (pageNum - 1) * pageMaxItemCount;
				con = DBManager.getConnection();

				if (categoryId == 0) {
					// 全検索
					st = con.prepareStatement("SELECT * FROM t_thread WHERE thread_category_id = ? ORDER BY id ASC LIMIT ?,? ");
					st.setInt(1, categoryId);
					st.setInt(2, startiItemNum);
					st.setInt(3, pageMaxItemCount);

				} else {
					// 商品名検索
					st = con.prepareStatement("SELECT * FROM t_thread WHERE thread_category_id = ? ORDER BY id ASC LIMIT ?,? ");
					st.setInt(1, categoryId);
					st.setInt(2, startiItemNum);
					st.setInt(3, pageMaxItemCount);
				}

				ResultSet rs = st.executeQuery();
				ArrayList<PostDataBeans> postList = new ArrayList<PostDataBeans>();

				while (rs.next()) {
					PostDataBeans post = new PostDataBeans();
					post.setId(rs.getInt("id"));
					post.setUserLoginId(rs.getString("user_login_id"));
					post.setThreadTitle(rs.getString("thread_title"));
					post.setThreadText(rs.getString("thread_text"));
					post.setThreadCategoryId(rs.getInt("thread_category_id"));
					post.setCreateDate(rs.getString("create_date"));

					postList.add(post);
				}
				System.out.println("get Items by itemName has been completed");
				return postList;
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
		public static double getItemCount(int searchWord) throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			try {
				con = DBManager.getConnection();
				st = con.prepareStatement("select count(*) as cnt from t_thread where thread_category_id = ?");
				st.setInt(1, searchWord);
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

	/**
	 * タイトル検索
	 * @param searchWord
	 * @param pageNum
	 * @param pageMaxItemCount
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<PostDataBeans> getItemsByItemName(String searchWord, int pageNum, int pageMaxItemCount) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			int startiItemNum = (pageNum - 1) * pageMaxItemCount;
			con = DBManager.getConnection();

			if (searchWord.length() == 0) {
				// 全検索
				st = con.prepareStatement("SELECT * FROM t_thread ORDER BY id ASC LIMIT ?,? ");
				st.setInt(1, startiItemNum);
				st.setInt(2, pageMaxItemCount);

			} else {
				// 商品名検索
				st = con.prepareStatement("SELECT * FROM t_thread WHERE thread_title like ? ORDER BY id ASC LIMIT ?,? ");
				st.setString(1,"%" + searchWord + "%");
				st.setInt(2, startiItemNum);
				st.setInt(3, pageMaxItemCount);
			}

			ResultSet rs = st.executeQuery();
			ArrayList<PostDataBeans> postList = new ArrayList<PostDataBeans>();

			while (rs.next()) {
				PostDataBeans post = new PostDataBeans();
				post.setId(rs.getInt("id"));
				post.setUserLoginId(rs.getString("user_login_id"));
				post.setThreadTitle(rs.getString("thread_title"));
				post.setThreadText(rs.getString("thread_text"));
				post.setThreadCategoryId(rs.getInt("thread_category_id"));
				post.setCreateDate(rs.getString("create_date"));

				postList.add(post);
			}
			System.out.println("get Items by itemName has been completed");
			return postList;
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
			st = con.prepareStatement("select count(*) as cnt from t_thread where thread_title like ?");
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
