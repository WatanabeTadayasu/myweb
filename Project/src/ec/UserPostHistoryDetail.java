package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.PostDataBeans;
import dao.PostDAO;

/**
 * 購入履歴画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/UserPostHistoryDetail")
public class UserPostHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			try {
				//選択された商品のIDを型変換し利用
				int id = Integer.parseInt(request.getParameter("thread_id"));
				//戻るページ表示用
				int pageNum = Integer.parseInt(request.getParameter("page_num")==null?"1":request.getParameter("page_num"));

				//購入詳細情報、購入情報を取得
				PostDataBeans bdbbb = PostDAO.getThreadDataBeansByBuyId(id);

//				// 購入アイテム情報
//				ArrayList<ItemDataBeans> buyIDBList = BuyDetailDAO.getItemDataBeansListByBuyId(id);

				//リクエストパラメーターにセット
				request.setAttribute("bdbbb", bdbbb);
//				request.setAttribute("buyIDBList", buyIDBList);
				request.setAttribute("pageNum", pageNum);

				request.getRequestDispatcher("/WEB-INF/jsp/userposthistorydetail.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("errorMessage", e.toString());
				response.sendRedirect("Error");
			}

		}

	}
