package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import dao.BuyDAO;

/**
 * 購入完了画面
 *
 * @author d-yamaguchi
 *
 */
@WebServlet("/BuyResult")
public class BuyResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {

			String inputThreadTitle = request.getParameter("thread_title");
			String inputThreadText = request.getParameter("thread_text");
			int inputThreadCategoryId = Integer.parseInt(request.getParameter("thread_category_id"));

			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setUserId((int) session.getAttribute("userId"));
			bdb.setThreadTitle(inputThreadTitle);
			bdb.setThreadText(inputThreadText);
			bdb.setThreadCategoryId(inputThreadCategoryId);


			// 登録が確定されたかどうか確認するための変数
			String confirmed = request.getParameter("confirm_button");

			switch (confirmed) {
			case "cancel":
				session.setAttribute("bdb", bdb);
				response.sendRedirect("Buy");
				break;

			case "regist":
				// 購入情報を登録
				int buyId = BuyDAO.insertBuy(bdb);

				/* ====購入完了ページ表示用==== */
				BuyDataBeans resultBDB = BuyDAO.getBuyDataBeansByBuyId(buyId);

				request.setAttribute("bdb", bdb);
				session.setAttribute("resultBDB", resultBDB);
				request.getRequestDispatcher("/WEB-INF/jsp/postresult.jsp").forward(request, response);
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