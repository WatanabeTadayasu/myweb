package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ThreadDataBeans;
import dao.PostDAO;
import dao.ThreadDAO;

/**
 * 投稿履歴から投稿削除画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/PostDelete")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        // サーブレットクラスの動作を決定する「action」の値を
        // リクエストパラメーターから取得(P142)
        String action = request.getParameter("action");

        // 「登録の開始」をリクエストされた時の処理
        if (action == null) {

        }

        // 登録確認画面から「登録実行」をリクエストされた時の処理
        if (action.equals("done")) {

            // セッションスコープに保存された登録ユーザーを取得
            HttpSession session = request.getSession();
            int[] deleteList = (int[]) session.getAttribute("deleteList");

            // 登録処理の呼び出し
            PostDAO logic = new PostDAO();
            logic.postdeletemethod(deleteList);

            // 不要となったセッションスコープ内のインスタンスを削除
            session.removeAttribute("deleteList");

            // 設定されたフォワード先にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userDeletedone.jsp");
            dispatcher.forward(request, response);
        }

    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		HttpSession session = request.getSession();
    		try {
    			String[] deleteItemIdList = request.getParameterValues("delete_item_id_list");
//    			ArrayList<PostDataBeans> bdbhList = (ArrayList<PostDataBeans>) session.getAttribute("bdbhList");

    			//対象のスレッド情報を取得
       			ThreadDataBeans thread = ThreadDAO.getThreadByThreadID(Integer.parseInt(request.getParameter("delete_item_id_list")));

    			int[] iarray = new int[deleteItemIdList.length];
    			for (int i = 0; i < iarray.length; i++) {
    			iarray[i] = Integer.parseInt(deleteItemIdList[i]);
    			}

    			String cartActionMessage = "";
    			if (deleteItemIdList != null) {
    				//削除対象の商品を削除
    				for (int deleteItemId : iarray) {
    					System.out.println(deleteItemId);
//    					bdbhList = new ArrayList<PostDataBeans>();
    					session.setAttribute("deleteList", deleteItemId);
    					session.setAttribute("thread", thread);
    					request.getRequestDispatcher("/WEB-INF/jsp/postdeleteconfirm.jsp").forward(request, response);
    				}

    			}

    			if (deleteItemIdList.length == 0) {
    				cartActionMessage = "削除する商品が選択されていません";
    			}



    			request.setAttribute("cartActionMessage", cartActionMessage);
    			request.getRequestDispatcher("/WEB-INF/jsp/userdata.jsp").forward(request, response);

    		} catch (Exception e) {
    			e.printStackTrace();
    			session.setAttribute("errorMessage", e.toString());
    			response.sendRedirect("Error");
    		}
    	}
    }
