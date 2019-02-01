package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログアウト画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// ログイン時に保存したセッション内のユーザ情報を削除
		session.removeAttribute("userId");
		session.removeAttribute("isLogin");
		request.removeAttribute("udb");
		session.setAttribute("logoutMessage", "ログアウトしました。");

//		// ログインのサーブレットにリダイレクト
		response.sendRedirect("Login");
//		request.getRequestDispatcher("/WEB-INF/jsp/logout.jsp").forward(request, response);
		}


}
