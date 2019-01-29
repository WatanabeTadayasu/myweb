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
 * Servlet implementation class Comment
 */
@WebServlet("/PostDetail")
public class PostDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
   	 * 投稿詳細画面
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		HttpSession session = request.getSession();
   		try {
   			//選択された商品のIDを型変換し利用
   			int id = Integer.parseInt(request.getParameter("thread_id"));
   			//戻るページ表示用
   			int pageNum = Integer.parseInt(request.getParameter("page_num")==null?"1":request.getParameter("page_num"));
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

//   			//対象のコメント情報を取得
//   			ArrayList<CommentDataBeans> commentList = CommentDetailDAO.getCommentDataBeansListByBuyId(id);

//   			/*コメントメソッド*/
//   			int commentid = (int) session.getAttribute("userId");
//   			UserDAO UserDAO = new UserDAO();
//   			UserDataBeans udb = UserDAO.findByDetailInfo(commentid);

//   			session.setAttribute("udb", udb);

   			//リクエストパラメーターにセット
			request.setAttribute("cartActionMessage", cartActionMessage);
			request.setAttribute("commentList", commentList);
   			request.setAttribute("thread", thread);
   			request.setAttribute("pageNum", pageNum);

   			request.getRequestDispatcher("/WEB-INF/jsp/postdetail.jsp").forward(request, response);
   		} catch (Exception e) {
   			e.printStackTrace();
   			session.setAttribute("errorMessage", e.toString());
   			response.sendRedirect("Error");
   		}
   	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
