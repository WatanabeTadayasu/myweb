package beans;

import java.io.Serializable;

/**
 * ユーザー
 * @author d-yamaguchi
 *
 */
public class UserDataBeans implements Serializable {
	private int id;
	private String loginId;
	private String name;
	private String birthdate;
	private String password;
	private String createDate;
	private String updateDate;
	private String password1;
	private String birthdate1;
	private String Address;
	private int threadCategoryId;

	// コンストラクタ
	public UserDataBeans() {
		this.name = "";
		this.birthdate = "";
		this.loginId = "";
		this.password = "";

	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getBirthdate1() {
		return birthdate1;
	}

	public void setBirthdate1(String birthdate1) {
		this.birthdate1 = birthdate1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ユーザー情報更新時の必要情報をまとめてセットするための処理
	 *
	 * @param name
	 * @param loginId
	 * @param address
	 */
	public void setUpdateUserDataBeansInfo(String loginId, String name, String password, String password1, String birthdate/*, int id*/) {
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.password1 = password1;
		this.birthdate = birthdate;
		/*this.id = id;*/
	}

	public void setUpdateUserDataBeansInfoPassNull(String loginId, String name, String birthdate) {
		this.loginId = loginId;
		this.name = name;
		this.birthdate = birthdate;
	}

	public void setUpdateUserDataBeansResult(String loginId, String name, String password, String birthdate/*, int id*/) {
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.birthdate = birthdate;
		/*this.id = id;*/
	}


	public UserDataBeans(int id, String loginId, String name, String password, String birthdate) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// ログインセッションを保存するためのコンストラクタ
		public UserDataBeans(String loginId, String name) {
			this.loginId = loginId;
			this.name = name;
		}


	public UserDataBeans(String loginId, String name, String birthdate, String password, String createDate,
			String updateDate) {
		this.loginId = loginId;
		this.name = name;
		this.birthdate = birthdate;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	// 全てのデータをセットするコンストラクタ
		public UserDataBeans(int id, String name, String loginId, String birthdate, String password, String createDate,
				String updateDate) {
			this.id = id;
			this.name = name;
			this.loginId = loginId;
			this.birthdate = birthdate;
			this.password = password;
			this.createDate = createDate;
			this.updateDate = updateDate;
		}

		// 検索のデータをセットするコンストラクタ
		public UserDataBeans(int id, String loginId, String name, String birthdate, String createDate,
				String updateDate) {
				this.id = id;
				this.loginId = loginId;
				this.name = name;
				this.birthdate = birthdate;
				this.createDate = createDate;
				this.updateDate = updateDate;
			}

		// 更新セッションを保存するためのコンストラクタ
		public UserDataBeans(String loginId, String name, String birthdate, String password, String updateDate) {
			this.name = name;
			this.birthdate = birthdate;
			this.password = password;
			this.loginId = loginId;
			this.updateDate = updateDate;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String Address) {
			this.Address = Address;
		}

		// 登録セッションを保存するためのコンストラクタ
		public UserDataBeans(String loginId, String name, String birthdate, String password) {
			this.loginId = loginId;
			this.name = name;
			this.birthdate = birthdate;
			this.password = password;
		}



		// 登録セッションを保存するためのコンストラクタ
		public void UserDataBeans1(String loginId) {
			this.loginId = loginId;
		}

		// 登録セッションを保存するためのコンストラクタ
		public void UserDataBeans2(String name) {
			this.name = name;
		}

		// 登録セッションを保存するためのコンストラクタ
		public void UserDataBeans3(String birthdate) {
			this.birthdate = birthdate;
		}

		// 登録セッションを保存するためのコンストラクタ
		public void UserDataBeans4( String password) {
			this.password = password;
		}

		//削除セッションを保存するためのコンストラクタ
				public UserDataBeans(String loginId) {
					this.loginId = loginId;
				}

				public int getThreadCategoryId() {
					return threadCategoryId;
				}

				public void setThreadCategoryId(int threadCategoryId) {
					this.threadCategoryId = threadCategoryId;
				}


}
