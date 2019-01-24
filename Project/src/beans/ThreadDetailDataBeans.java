package beans;

import java.io.Serializable;

/**
 * 購入詳細
 * @author d-yamaguchi
 *
 */
public class ThreadDetailDataBeans  implements Serializable {
	private int id;
	private int threadId;
	private int commentId;

	public int getId() {
		return id;
	}
	public void setId(int threadDetailId) {
		this.id = threadDetailId;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

}
