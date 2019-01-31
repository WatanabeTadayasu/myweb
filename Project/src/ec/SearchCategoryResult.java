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
 * Servlet implementation class SearchCategoryResult
 */
@WebServlet("/SearchCategoryResult")
public class SearchCategoryResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//1ページに表示する商品数
			final static int PAGE_MAX_ITEM_COUNT = 8;

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession();
				try {

					int searchWord = Integer.parseInt(request.getParameter("thread_category_id"));
					//表示ページ番号 未指定の場合 1ページ目を表示
					int pageNum = Integer.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
					// 新たに検索されたキーワードをセッションに格納する
					session.setAttribute("searchWord", searchWord);

					// 商品リストを取得 ページ表示分のみ
					ArrayList<PostDataBeans> searchResultItemList = PostDAO.getItemsByCategoryId(searchWord, pageNum, PAGE_MAX_ITEM_COUNT);

					// 検索ワードに対しての総ページ数を取得
					double itemCount = PostDAO.getItemCount(searchWord);
					int pageMax = (int) Math.ceil(itemCount / PAGE_MAX_ITEM_COUNT);

					String searchEerrorMessage = "";

					if (searchResultItemList.size() == 0) {
						searchEerrorMessage += "該当する投稿履歴はありません。<br>";
						request.setAttribute("searchEerrorMessage", searchEerrorMessage);
						request.getRequestDispatcher("/WEB-INF/jsp/tp.jsp").forward(request, response);
					}

					//総アイテム数
					request.setAttribute("itemCount", (int) itemCount);
					// 総ページ数
					request.setAttribute("pageMax", pageMax);
					// 表示ページ
					request.setAttribute("pageNum", pageNum);
					request.setAttribute("threadList", searchResultItemList);

					request.getRequestDispatcher("/WEB-INF/jsp/searchcategoryresult.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					session.setAttribute("errorMessage", e.toString());
					response.sendRedirect("Error");
				}
			}

}
