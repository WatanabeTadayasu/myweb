package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CommentDataBeans;

/**
 * Servlet implementation class CommentConfirm
 */
@WebServlet("/CommentConfirm")
public class CommentConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("utf-8");

	HttpSession session = request.getSession();

	try {
//		//選択された配送方法IDを取得
//		int inputThreadCategoryId = Integer.parseInt(request.getParameter("thread_category_id"));
//		//選択されたIDをもとに配送方法Beansを取得
//		//DeliveryMethodDataBeans userSelectDMB = DeliveryMethodDAO.getDeliveryMethodDataBeansByID(inputDeliveryMethodId);
//		ThreadCategoryDataBeans dmdb = ThreadCategoryDAO.getThreadCategoryDataBeansByID(inputThreadCategoryId);
//		//買い物かご
//		ArrayList<ItemDataBeans> cartIDBList = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
//		//合計金額
//		int totalPrice = EcHelper.getTotalItemPrice(cartIDBList) + dmdb.getPrice();


//		int threadCategoryId = dmdb.getId();
//		String threadCategoryName = dmdb.getName();

		int threadId = Integer.parseInt(request.getParameter("thread_id"));
		String userLoginId = request.getParameter("user_login_id");
		String comment = request.getParameter("m_comment");

		CommentDataBeans comme = new CommentDataBeans();

		comme.setThreadId(threadId);
		comme.setUserLoginId(userLoginId);
		comme.setComment(comment);
//		bdb.setThreadCategoryId(threadCategoryId);
//		bdb.setThreadCategoryName(threadCategoryName);
//
//		int userId = (int) session.getAttribute("userId");
//
//		ThreadCategoryDataBeans selectDMB = new ThreadCategoryDataBeans();
//		bdb.setDeliveryMethodId(userSelectDMB.getId());
//		bdb.setDeliveryMethodName(userSelectDMB.getName());
//		bdb.setDeliveryMethodPrice(userSelectDMB.getPrice());

		String validationMessage = "";

		// 入力チェック
		if (comment.equals("")) {
			validationMessage += "コメントを入力して下さい。<br>";
		}

		// バリデーションエラーメッセージがないなら確認画面へ
		if (validationMessage.length() == 0) {
			//購入確定で利用
			session.setAttribute("comme", comme);
//			request.setAttribute("userSelectDMB", dmdb);
			request.getRequestDispatcher("/WEB-INF/jsp/commentconfirm.jsp").forward(request, response);
		} else {
//			session.setAttribute("bdb", bdb);
			session.setAttribute("validationMessage", validationMessage);
			response.sendRedirect("Comment");
		}

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("errorMessage", e.toString());
		response.sendRedirect("Error");
	}
}

}
