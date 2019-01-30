package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ThreadDataBeans;
import beans.UserDataBeans;
import dao.ThreadDAO;
import dao.UserDAO;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/Comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment() {
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
//   			int id = Integer.parseInt(request.getParameter("thread_id"));
   			//戻るページ表示用
   			int pageNum = Integer.parseInt(request.getParameter("page_num")==null?"1":request.getParameter("page_num"));

//   			// 更新確認画面から戻ってきた場合Sessionから取得。それ以外はuserIdでユーザーを取得
//			UserDAO UserDAO = new UserDAO();
//			UserDataBeans udb = session.getAttribute("returnUDB") == null ? UserDAO.findByLoginInfo(Integer.parseInt(request.getParameter("userId"))) : (UserDataBeans) EcHelper.cutSessionAttribute(session, "returnUDB");

//   			//対象のスレッド情報を取得
//   			ThreadDataBeans thread = ThreadDAO.getThreadByThreadID(Integer.parseInt(request.getParameter("thread_id")));

//   			//対象のコメント情報を取得
//   			ArrayList<CommentDataBeans> commentList = CommentDetailDAO.getCommentDataBeansListByBuyId(id);

   			if (request.getParameter("thread_id") == null) {

   			int id = ((ThreadDataBeans) session.getAttribute("thread")).getId();
   			String userLoginId = ((ThreadDataBeans) session.getAttribute("thread")).getUserLoginId();
   			String threadTitle = ((ThreadDataBeans) session.getAttribute("thread")).getThreadTitle();
   			String threadText = ((ThreadDataBeans) session.getAttribute("thread")).getThreadText();
   			String createDate = ((ThreadDataBeans) session.getAttribute("thread")).getCreateDate();

   			ThreadDataBeans tdb = new ThreadDataBeans();
   			tdb.setId(id);
   			tdb.setUserLoginId(userLoginId);
   			tdb.setThreadTitle(threadTitle);
   			tdb.setThreadText(threadText);
   			tdb.setCreateDate(createDate);
   			session.setAttribute("thread", tdb);

   			}else {

   			//対象のスレッド情報を取得
   			ThreadDataBeans thread = ThreadDAO.getThreadByThreadID(Integer.parseInt(request.getParameter("thread_id")));
   			session.setAttribute("thread", thread);

   			}

   			/*コメントメソッド*/
   			int commentid = (int) session.getAttribute("userId");
   			UserDAO UserDAO = new UserDAO();
   			UserDataBeans udb = UserDAO.findByDetailInfo(commentid);

   			session.setAttribute("udb", udb);

   			//リクエストパラメーターにセット
//   			session.setAttribute("thread", thread);
//   			request.setAttribute("commentList", commentList);
   			request.setAttribute("pageNum", pageNum);

   			request.getRequestDispatcher("/WEB-INF/jsp/comment.jsp").forward(request, response);

   		} catch (Exception e) {
   			e.printStackTrace();
   			session.setAttribute("errorMessage", e.toString());
   			response.sendRedirect("Error");
   		}
   	}

}
