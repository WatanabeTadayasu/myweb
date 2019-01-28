package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CommentDataBeans;
import beans.ThreadDataBeans;
import dao.CommentDetailDAO;
import dao.ThreadDAO;

/**
 * 購入履歴画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/CommentHistoryDetail")
public class CommentHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("thread_id"));
			//戻るページ表示用
			int pageNum = Integer.parseInt(request.getParameter("page_num")==null?"1":request.getParameter("page_num"));

//			//購入詳細情報、購入情報を取得
//			PostDataBeans bdbbb = PostDAO.getBuyDataBeansByBuyId(id);
//
//			// 購入アイテム情報
//			ArrayList<ItemDataBeans> buyIDBList = BuyDetailDAO.getItemDataBeansListByBuyId(id);

			//対象のスレッド情報を取得
   			ThreadDataBeans thread = ThreadDAO.getThreadByThreadID(id);
			ArrayList<CommentDataBeans> commentList = CommentDetailDAO.getCommentDataBeansListByBuyId(id);

			//セッションにカートがない場合カートを作成
			if (commentList == null) {
				commentList = new ArrayList<CommentDataBeans>();
				session.setAttribute("commentList", commentList);
			}

			String cartActionMessage = "";
			//カートに商品が入っていないなら
			if(commentList.size() == 0) {
				cartActionMessage = "コメント履歴がありません。";
			}

			//リクエストパラメーターにセット
//			request.setAttribute("bdbbb", bdbbb);
//			request.setAttribute("buyIDBList", buyIDBList);
			request.setAttribute("cartActionMessage", cartActionMessage);
			request.setAttribute("thread", thread);
			request.setAttribute("commentList", commentList);
			request.setAttribute("pageNum", pageNum);

			request.getRequestDispatcher("/WEB-INF/jsp/commenthistorydetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
