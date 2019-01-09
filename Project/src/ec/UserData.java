package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * ユーザー情報画面
 *
 * @author d-yamaguchi
 *
 */
@WebServlet("/UserData")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッション開始
		HttpSession session = request.getSession();

		try {
			// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる
			if (session.getAttribute("userId") == null){
				// if (session == null){
				// session = request.getSession(true);
				// ログインのサーブレットにリダイレクト
				response.sendRedirect("Login");
			}else {

//			// ログイン時に取得したユーザーIDをセッションから取得
//			int userId = (int) session.getAttribute("userInfo");

			// URLからGETパラメータとしてIDを受け取る
			String num = request.getParameter("userId");
			int userId = Integer.parseInt(num);

			// 更新確認画面から戻ってきた場合Sessionから取得。それ以外はuserIdでユーザーを取得
			UserDAO UserDAO = new UserDAO();
			UserDataBeans udb = session.getAttribute("returnUDB") == null ? UserDAO.findByLoginInfo(userId) : (UserDataBeans) EcHelper.cutSessionAttribute(session, "returnUDB");

			// 入力された内容に誤りがあったとき等に表示するエラーメッセージを格納する
			String validationMessage = (String) EcHelper.cutSessionAttribute(session, "validationMessage");

//			ArrayList<BuyDataBeans> bdbhList = BuyDAO.getBuyDataBeansHistory();

			request.setAttribute("validationMessage", validationMessage);
			request.setAttribute("udb", udb);
//			request.setAttribute("bdbhList", bdbhList);

			request.getRequestDispatcher("/WEB-INF/jsp/userdata.jsp").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
