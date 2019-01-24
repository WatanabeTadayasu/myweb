package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ThreadDataBeans;
import dao.ThreadDAO;

/**
 * スタート画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {

			// TODO 未実装：ログインセッションがある場合
			 if (session.getAttribute("userId") != null){

			//商品情報を取得
			ArrayList<ThreadDataBeans> threadList = ThreadDAO.getRandItem(4);

			//リクエストスコープにセット
			request.setAttribute("threadList", threadList);

		}

			//セッションにsearchWordが入っていたら破棄する
			String searchWord = (String)session.getAttribute("searchWord");
			if(searchWord != null) {
				session.removeAttribute("searchWord");
			}else {

			request.getRequestDispatcher("/WEB-INF/jsp/tp.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
