package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.PostDataBeans;
import dao.PostDAO;

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
			//投稿情報をランダムに取得
			ArrayList<PostDataBeans> threadList = PostDAO.getRandThread(4);
//			//投稿情報をランダムに取得
			ArrayList<PostDataBeans> quickThreadList = PostDAO.getQuickThread(4);

			//リクエストスコープにセット
			request.setAttribute("threadList", threadList);
			request.setAttribute("quickThreadList", quickThreadList);
		}

			//セッションにsearchWordが入っていたら破棄する
			String searchWord = (String)session.getAttribute("searchWord");
			if(searchWord != null) {
				session.removeAttribute("searchWord");
				request.getRequestDispatcher("/WEB-INF/jsp/tp.jsp").forward(request, response);
			}else {
			session.removeAttribute("logoutMessage");
			session.removeAttribute("validationMessage");
			request.getRequestDispatcher("/WEB-INF/jsp/tp.jsp").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
