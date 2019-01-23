package beans;

import java.io.Serializable;

/**
 * アイテム
 * @author d-yamaguchi
 *
 */
public class CommentDataBeans implements Serializable {
	private int id;
	private int threadId;
	private String userLoginId;
	private String comment;
	private String createDate;

	public CommentDataBeans(int id, int threadId, String userLoginId, String comment, String createDate) {
		this.id = id;
		this.threadId = threadId;
		this.userLoginId = userLoginId;
		this.comment = comment;
		this.createDate = createDate;
	}
	public CommentDataBeans() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public int getId() {
		return id;
	}
	public void setId(int itemId) {
		this.id = itemId;
	}
	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}





}
