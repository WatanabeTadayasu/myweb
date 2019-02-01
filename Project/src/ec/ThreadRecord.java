package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ThreadRecordBeans;
import dao.ThreadRecordDAO;

/**
 * Servlet implementation class ThreadRecord
 */
@WebServlet("/ThreadRecord")
public class ThreadRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
   	 * 投稿評価画面
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		HttpSession session = request.getSession();
   		try {

   			//レコード登録
   			int inputUserId = (int) session.getAttribute("userId");
   			int inputThresdId = Integer.parseInt(request.getParameter("thread_id"));

			ThreadRecordBeans trb = new ThreadRecordBeans();
			trb.setUserId(inputUserId);
			trb.setThreadId(inputThresdId);

			ThreadRecordDAO.insertRecord(trb);

			//スレッドIDに対して評価数を取得
			double itemCount = ThreadRecordDAO.getItemCount(inputThresdId);

			//総アイテム数
			request.setAttribute("itemCount", (int) itemCount);

   			request.getRequestDispatcher("/WEB-INF/jsp/postdetail.jsp").forward(request, response);

   		} catch (Exception e) {
   			e.printStackTrace();
   			session.setAttribute("errorMessage", e.toString());
   			response.sendRedirect("Error");
   		}
   	}

}
