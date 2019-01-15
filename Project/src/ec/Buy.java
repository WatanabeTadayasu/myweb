package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ThreadCategoryDataBeans;
import dao.ThreadCategoryDAO;

/**
 * 商品購入画面
 *
 * @author d-yamaguchi
 *
 */
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッション
		HttpSession session = request.getSession();

		try {

			Boolean isLogin = session.getAttribute("isLogin") != null ? (Boolean) session.getAttribute("isLogin") : false;
//			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			if (!isLogin) {
				// Sessionにリターンページ情報を書き込む
				session.setAttribute("returnStrUrl", "Buy");
				// Login画面にリダイレクト
				response.sendRedirect("Login");

//			} else if (cart.size() == 0) {
//				request.setAttribute("cartActionMessage", "購入する商品がありません");
//				request.getRequestDispatcher(EcHelper.CART_PAGE).forward(request, response);
			} else {
				// 配送方法をDBから取得
				ArrayList<ThreadCategoryDataBeans> dMDBList = ThreadCategoryDAO.getAllThreadCategoryDataBeans();

				/*投稿メソッド
				int id = (int) session.getAttribute("userId");
				UserDAO UserDAO = new UserDAO();
				UserDataBeans udb = UserDAO.findByDetailInfo(id);

				request.setAttribute("udb", udb);*/
				request.setAttribute("dmdbList", dMDBList);
				request.getRequestDispatcher("/WEB-INF/jsp/post.jsp").forward(request, response);


			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
