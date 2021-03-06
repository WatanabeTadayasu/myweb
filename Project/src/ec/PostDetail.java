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
import beans.PostDataBeans;
import dao.CommentDAO;
import dao.PostDAO;
import dao.ThreadRecordDAO;

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
   			//ThreadDataBeans thread = ThreadDAO.getThreadByThreadID(id);
   			PostDataBeans thread = PostDAO.getThreadDataBeansByBuyId(id);

   			ArrayList<CommentDataBeans> commentList = CommentDAO.getCommentDataBeansListByBuyId(id);

   			//スレッドIDに対して評価数を取得
			int itemCount = ThreadRecordDAO.getItemCount(id);

			//セッションにコメントがない場合コメントリストを作成
			if (commentList == null) {
				commentList = new ArrayList<CommentDataBeans>();
				session.setAttribute("commentList", commentList);
			}

			String cartActionMessage = "";
			//コメントリストにコメントが入っていないなら
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
			request.setAttribute("itemCount", itemCount);
			request.setAttribute("commentList", commentList);
			session.setAttribute("thread", thread);
   			request.setAttribute("pageNum", pageNum);

   			request.getRequestDispatcher("/WEB-INF/jsp/postdetail.jsp").forward(request, response);
   		} catch (Exception e) {
   			e.printStackTrace();
   			session.setAttribute("errorMessage", e.toString());
   			response.sendRedirect("Error");
   		}
   	}

}
