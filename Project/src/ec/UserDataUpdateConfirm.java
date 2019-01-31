package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;

/**
 * ユーザー情報更新入力内容確認画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/UserDataUpdateConfirm")
public class UserDataUpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*文字化け対策*/
		request.setCharacterEncoding("UTF-8");

		//セッション開始
		HttpSession session = request.getSession();
		try {
			//エラーメッセージを格納する変数
			String validationMessage = "";

			//入力フォームから受け取った値をBeansにセット
			UserDataBeans udb = new UserDataBeans();

			//パスワードチェック
			/*if (udb.getPassword().equals("") || (udb.getPassword1().equals(""))) {
				udb.setUpdateUserDataBeansInfoPassNull(request.getParameter("login_id"), request.getParameter("user_name"), request.getParameter("birthdate"));
			}else {*/
			udb.setUpdateUserDataBeansInfo(request.getParameter("login_id"), request.getParameter("user_name"), request.getParameter("password"), request.getParameter("password1"), request.getParameter("birthdate")/*, (int) session.getAttribute("userId")*/);
			/*}*/

//			//ログインIDの入力規則チェック 英数字 ハイフン アンダースコアのみ入力可能
//			if (!EcHelper.isLoginIdValidation(udb.getLoginId())) {
//				validationMessage = "半角英数とハイフン、アンダースコアのみ入力できます";
//			}
//			//loginIdの重複をチェック
//			if ( UserDAO.isOverlapLoginId(udb.getLoginId(),(int) session.getAttribute("userId"))) {
//				validationMessage = "ほかのユーザーが使用中のログインIDです";
//			}
			//未入力チェック
			if (udb.getName().equals("") || udb.getLoginId().equals("") || udb.getBirthdate().equals("")) {
				validationMessage = "入力された内容は正しくありません。";
			}

			//パスワードチェック
			if (!udb.getPassword().equals(udb.getPassword1())) {
				validationMessage = "パスワードが異なっています。";
			}

			//パスワードチェック
			if (!udb.getPassword().equals("") && udb.getPassword1().equals("")) {
				validationMessage = "パスワードを入力してください。";
			}

			//パスワードチェック
			if (udb.getPassword().equals("") && !udb.getPassword1().equals("")) {
				validationMessage = "パスワードを入力してください。";
			}

			//バリデーションエラーメッセージがないなら確認画面へ
			if(validationMessage.length() == 0){
				//確認画面へ
				request.setAttribute("udb",udb);
				request.getRequestDispatcher(EcHelper.USER_DATA_UPDATE_CONFIRM_PAGE).forward(request, response);
			}else {
				//セッションにエラーメッセージを持たせてユーザー画面へ
				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("UserData");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
