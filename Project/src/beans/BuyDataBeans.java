package beans;

import java.io.Serializable;

/**
 * 購入データ
 * @author d-yamaguchi
 *
 */
public class BuyDataBeans  implements Serializable {
	private int id;
	private int userId;
	private int threadCategoryId;
	private String threadTitle;
	private String threadText;
	private String createDate;


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
	public int getThreadCategoryId() {
		return threadCategoryId;
	}
	public void setThreadCategoryId(int threadCategoryId) {
		this.threadCategoryId = threadCategoryId;
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


//	public String getFormatDate() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
//		return sdf.format(buyDate);
//	}


}
