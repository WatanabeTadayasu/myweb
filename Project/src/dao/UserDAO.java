package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import base.DBManager;
import beans.UserDataBeans;
import ec.EcHelper;

/**
 *
 * @author d-yamaguchi
 *
 */
public class UserDAO {
	// インスタンスオブジェクトを返却させてコードの簡略化

	/**
	 * データの挿入処理を行う。現在時刻は挿入直前に生成
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void insertUser(UserDataBeans udb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO t_user(name,login_id,login_password,birth_date,create_date,update_date) VALUES(?,?,?,?,?,?)");
			st.setString(1, udb.getName());
			st.setString(2, udb.getLoginId());
			st.setString(3, EcHelper.getMd5(udb.getPassword()));
			st.setString(4, udb.getBirthdate());
			st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
			System.out.println("inserting user has been completed");
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
	 * ユーザーIDを取得
	 *
	 * @param loginId
	 *            ログインID
	 * @param password
	 *            パスワード
	 * @return int ログインIDとパスワードが正しい場合対象のユーザーID 正しくない||登録されていない場合0
	 * @throws SQLException
	 *             呼び出し元にスロー
	 */
	public static int getUserId(String loginId, String password) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM t_user WHERE login_id = ?");
			st.setString(1, loginId);

			ResultSet rs = st.executeQuery();

			int userId = 0;
			while (rs.next()) {
				if (EcHelper.getMd5(password).equals(rs.getString("login_password"))) {
					userId = rs.getInt("id");
					System.out.println("login succeeded");
					break;
				}
			}

			System.out.println("searching userId by loginId has been completed");
			return userId;
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
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public UserDataBeans findByLoginInfo(String loginId, String result) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM t_user WHERE login_id = ? and login_password = ?";

            // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, result);
            ResultSet rs = pStmt.executeQuery();

            // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new UserDataBeans(loginIdData, nameData);

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
    }

    /*idに紐づくユーザー情報を返す*/

    public UserDataBeans findByDetailInfo(int id) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM t_user WHERE id = ?";

            // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

         // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String birthdate = rs.getString("birth_date");
                String password = rs.getString("login_password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                return new UserDataBeans(loginId, name, birthdate, password, createDate, updateDate);

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
    }


	/**
	 * ユーザーIDからユーザー情報を取得する
	 *
	 * @param useId
	 *            ユーザーID
	 * @return udbList 引数から受け取った値に対応するデータを格納する
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためスロー
	 */
	public static UserDataBeans getUserDataBeansByUserId(int userId) throws SQLException {
		UserDataBeans udb = new UserDataBeans();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT id, login_id, login_password, name, birth_date, FROM t_user WHERE id=" + userId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				udb.setId(rs.getInt("id"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setPassword(rs.getString("login_password"));
				udb.setName(rs.getString("name"));
				udb.setBirthdate(rs.getString("birth_date"));
			}

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("searching UserDataBeans by userId has been completed");
		return udb;
	}



	/**
	 * ユーザー情報の更新処理を行う。
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void updateUser(UserDataBeans udb) throws SQLException {
		// 更新された情報をセットされたJavaBeansのリスト
		UserDataBeans updatedUdb = new UserDataBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();
			st = con.prepareStatement("UPDATE t_user SET name=?, login_password=?, birth_date=?, update_date=? WHERE login_id=?;");
			st.setString(1, udb.getName());
			st.setString(2, udb.getPassword());
			st.setString(3, udb.getBirthdate());
			st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			st.setString(5, udb.getLoginId());
			st.executeUpdate();
			System.out.println("update has been completed");

			st = con.prepareStatement("SELECT name, login_password, birth_date, update_date FROM t_user WHERE login_id=" + udb.getLoginId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				updatedUdb.setName(rs.getString("name"));
				updatedUdb.setPassword(rs.getString("login_password"));
				updatedUdb.setBirthdate(rs.getString("birth_date"));
				updatedUdb.setUpdateDate(rs.getString("update_date"));
			}

			st.close();
			System.out.println("searching updated-UserDataBeans has been completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/*idに紐づくユーザー情報を返す*/

    public UserDataBeans findByLoginInfo(int userId) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM t_user WHERE id = ?";

            // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, userId);
            ResultSet rs = pStmt.executeQuery();

         // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String birthdate = rs.getString("birth_date");
                String password = rs.getString("login_password");
                /*String createDate = rs.getString("create_date");*/
                String updateDate = rs.getString("update_date");
                return new UserDataBeans(loginId, name, birthdate, password, updateDate);

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
    }

	/**
	 * loginIdの重複チェック
	 *
	 * @param loginId
	 *            check対象のログインID
	 * @param userId
	 *            check対象から除外するuserID
	 * @return bool 重複している
	 * @throws SQLException
	 */
	public static boolean isOverlapLoginId(String loginId, int userId) throws SQLException {
		// 重複しているかどうか表す変数
		boolean isOverlap = false;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			// 入力されたlogin_idが存在するか調べる
			st = con.prepareStatement("SELECT login_id FROM t_user WHERE login_id = ? AND id != ?");
			st.setString(1, loginId);
			st.setInt(2, userId);
			ResultSet rs = st.executeQuery();

			System.out.println("searching loginId by inputLoginId has been completed");

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


	 /*  String loginId;
		private String name;
		private Date birthDate;
		private String password;
		private String createDate;
		private String updateDate;

	    ユーザー削除*/

	    public void deletemethod(String loginId) {
			// TODO 自動生成されたメソッド・スタブ
	    	Connection conn = null;
	    	try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "DELETE FROM t_user WHERE login_id = ?";

	             // SELECTを実行し、結果表を取得
	            PreparedStatement pStmt = conn.prepareStatement(sql);

	            conn.setAutoCommit(false);

	            pStmt.setString(1, loginId);

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

	    /*idに紐づくユーザー情報を返す*/

	    public UserDataBeans findDeleteInfo(int id) {
	        Connection conn = null;

	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "SELECT * FROM t_user WHERE id = ?";

	            // SELECTを実行し、結果表を取得
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setInt(1, id);
	            ResultSet rs = pStmt.executeQuery();

	         // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
	            if (!rs.next()) {
	                return null;
	            }

	                String loginId = rs.getString("login_id");
	                String name = rs.getString("name");

	                return new UserDataBeans(loginId, name);

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
	    }


	 /*検索*/

    public List<UserDataBeans> findSearch(String loginIdP, String nameP, String birthdateP, String birthdateP1) {
        Connection conn = null;
        List<UserDataBeans> userList = new ArrayList<UserDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM t_user WHERE login_id != 'admin'";

            if(!loginIdP.equals("")) {
            	sql += " AND login_id = '" + loginIdP  + "'" ;
            }

            if(!nameP.equals("")) {
            	sql += " AND name like '%" + nameP  + "%'" ;
            }

            if(!birthdateP.equals("")) {
            	sql += " AND birth_date >= '" + birthdateP  + "'" ;
            }

            if(!birthdateP1.equals("")) {
            	sql += " AND birth_date <= '" + birthdateP1  + "'" ;
            }

            System.out.println(sql);

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String birthdate = rs.getString("birth_date");
                /*String password = rs.getString("password");*/
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                UserDataBeans user = new UserDataBeans(id, loginId, name, birthdate/*, password*/, createDate, updateDate);

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

    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<UserDataBeans> findAll() {
        Connection conn = null;
        List<UserDataBeans> userList = new ArrayList<UserDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM t_user WHERE login_id != 'admin'";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String birthdate = rs.getString("birth_date");
                String password = rs.getString("login_password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                UserDataBeans user = new UserDataBeans(id, loginId, name, birthdate, password, createDate, updateDate);

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

    /*暗号化*/

    public String hash(String password) {

    	//ハッシュを生成したい元の文字列
    	//String source = "暗号化対象";
    	String source = password;
    	//ハッシュ生成前にバイト配列に置き換える際のCharset
    	Charset charset = StandardCharsets.UTF_8;
    	//ハッシュアルゴリズム
    	String algorithm = "MD5";
    	//ハッシュ生成処理
    	byte[] bytes = null;

		try {

			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));

		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    	String result = DatatypeConverter.printHexBinary(bytes);
    	//標準出力
    	System.out.println(result);

		return result;
    }


}




