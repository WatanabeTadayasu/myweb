package beans;

import java.io.Serializable;

/**
 * 配送方法
 * @author d-yamaguchi
 *
 */
public class ThreadRecordBeans implements Serializable {

	private int id;
	private int userId;
	private int threadId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
}
