package beans;

import java.io.Serializable;

/**
 * アイテム
 * @author d-yamaguchi
 *
 */
public class ThreadDataBeans implements Serializable {
	private int id;
	private int threadCategoryId;
	private String userLoginId;
	private String threadTitle;
	private String threadText;
	private String createDate;

	public int getId() {
		return id;
	}
	public void setId(int itemId) {
		this.id = itemId;
	}

	public int getThreadCategoryId() {
		return threadCategoryId;
	}
	public void setThreadCategoryId(int threadCategoryId) {
		this.threadCategoryId = threadCategoryId;
	}

	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getThreadTitle() {
		return threadTitle;
	}
	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}
	public String getThreadText() {
		return threadText;
	}
	public void setThreadText(String threadText) {
		this.threadText = threadText;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}





}
