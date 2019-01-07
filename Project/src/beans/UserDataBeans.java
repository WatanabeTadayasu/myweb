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

	public String getAddress() {
		return birthdate;
	}

	public void setAddress(String address) {
		this.birthdate = address;
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
	public void setUpdateUserDataBeansInfo(String name, String loginId, String address, int id) {
		this.name = name;
		this.loginId = loginId;
		this.birthdate = address;
		this.id = id;
	}

	public UserDataBeans(String loginId, String name, String birthdate, String birthdate1) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserDataBeans(int id2, String loginId2, String name2, String birthdate, String password2, String createDate,
			String updateDate) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserDataBeans(String loginIdData, String nameData) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserDataBeans(String loginId2) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserDataBeans(String loginId2, String name2, String birthdate, String password2, String createDate,
			String updateDate) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
