package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.CommentDataBeans;

public class CommentDAO {

	/**
	 * 購入情報登録処理
	 * @param bdb 購入情報
	 * @return
	 * @throws SQLException 呼び出し元にスローさせるため
	 */
	public static int insertComment(CommentDataBeans comme) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO m_comment(thread_id,name,m_comment,create_date) VALUES (?,?,?,now())"
					 , Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, comme.getThreadId());
			st.setString(2, comme.getUserLoginId());
			st.setString(3, comme.getComment());
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
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<CommentDataBeans> findAll() {
        Connection conn = null;
        List<CommentDataBeans> userList = new ArrayList<CommentDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM m_comment WHERE login_id != 'admin'";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                int threadId = rs.getInt("thread_id");
                String userLoginId = rs.getString("name");
                String comment = rs.getString("m_comment");
                String createDate = rs.getString("create_date");
                CommentDataBeans user = new CommentDataBeans(id, threadId, userLoginId, comment, createDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;

    }
}