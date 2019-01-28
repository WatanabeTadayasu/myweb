package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CommentDataBeans;
import dao.CommentDAO;

/**
 * Servlet implementation class CommentResult
 */
@WebServlet("/CommentResult")
public class CommentResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentResult() {
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

			int inputThreadId = Integer.parseInt(request.getParameter("thread_id"));
			String inputuserLoginId = request.getParameter("user_login_id");
			String inputComment = request.getParameter("m_comment");

			CommentDataBeans comme = new CommentDataBeans();
			comme.setThreadId(inputThreadId);
			comme.setUserLoginId(inputuserLoginId);
			comme.setComment(inputComment);

			// 登録が確定されたかどうか確認するための変数
			String confirmed = request.getParameter("confirm_button");

			switch (confirmed) {
			case "cancel":
				session.setAttribute("comme", comme);
				response.sendRedirect("Comment");
				break;

			case "regist":
//				// コメント情報を登録
//				int commentId =
				CommentDAO.insertComment(comme);

//				//コメント詳細情報をコメント情報IDに紐づけして登録
//				CommentDetailDataBeans cddb = new CommentDetailDataBeans();
//				cddb.setThreadId(inputThreadId);
//				cddb.setCommentId(commentId);
//				CommentDetailDAO.insertCommentDetail(cddb);

//				/* ====購入完了ページ表示用==== */
//				PostDataBeans resultBDB = PostDAO.getBuyDataBeansByBuyId(buyId);

				request.setAttribute("comme", comme);
//				session.setAttribute("resultBDB", resultBDB);
				request.getRequestDispatcher("/WEB-INF/jsp/commentresult.jsp").forward(request, response);
				break;
			}

//			// セッションからカート情報を取得
//			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) EcHelper.cutSessionAttribute(session, "cart");
//
//			BuyDataBeans bdb = (BuyDataBeans) EcHelper.cutSessionAttribute(session, "bdb");
//
////			int userId = (int) session.getAttribute("userId");
////			int totalPrice = (int) session.getAttribute("totalPrice");
////			int delivertMethodId = (int) session.getAttribute("delivertMethodId");
//			//userId, totalPrice, delivertMethodId
//			// 購入情報を登録
//			int buyId = BuyDAO.insertBuy(bdb);
//			// 購入詳細情報を購入情報IDに紐づけして登録
//			for (ItemDataBeans cartInItem : cart) {
//				BuyDetailDataBeans bddb = new BuyDetailDataBeans();
//				bddb.setBuyId(buyId);
//				bddb.setItemId(cartInItem.getId());
//				BuyDetailDAO.insertBuyDetail(bddb);
//			}
//
//
//			/* ====購入完了ページ表示用==== */
//			BuyDataBeans resultBDB = BuyDAO.getBuyDataBeansByBuyId(buyId);
//			request.setAttribute("resultBDB", resultBDB);
//
//			// 購入アイテム情報
//			ArrayList<ItemDataBeans> buyIDBList = BuyDetailDAO.getItemDataBeansListByBuyId(buyId);
//			request.setAttribute("buyIDBList", buyIDBList);
//
//			// 購入完了ページ
//			request.getRequestDispatcher(EcHelper.BUY_RESULT_PAGE).forward(request, response);


		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
