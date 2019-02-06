package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.CommentDAO;
import dao.PostDAO;
import dao.UserDAO;

/**
 * 投稿履歴から投稿削除画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/PostDelete")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		HttpSession session = request.getSession();
    		try {
    			String[] deleteItemIdList = request.getParameterValues("delete_item_id_list");
//    			ArrayList<PostDataBeans> bdbhList = (ArrayList<PostDataBeans>) session.getAttribute("bdbhList");

//    			//対象のスレッド情報を取得
//    			PostDataBeans thread = PostDAO.getBuyDataBeansByBuyId(Integer.parseInt(request.getParameter("delete_item_id_list")));

//    			int[] iarray = new int[deleteItemIdList.length];
//    			for (int i = 0; i < iarray.length; i++) {
//    			iarray[i] = Integer.parseInt(deleteItemIdList[i]);
//    			}

    			String cartActionMessage = "";

    			if (deleteItemIdList != null) {
    				//削除対象の商品を削除
    				for (String deleteItemId : deleteItemIdList) {
//    					for (int cartInItem : threadList) {
//    						if (cartInItem.getId() == Integer.parseInt(deleteItemId)) {
    				for (int i = 0 ; i < deleteItemIdList.length ;){
    							PostDAO.postdeletemethod(Integer.parseInt(deleteItemId));
    							CommentDAO.commentdeletemethod(Integer.parseInt(deleteItemId));
    							break;
//    						}
//    					}
    				}
    			}
    				cartActionMessage = "削除しました";
    				request.setAttribute("cartActionMessage", cartActionMessage);
    				request.getRequestDispatcher("/WEB-INF/jsp/postdeletedone.jsp").forward(request, response);

    			}else{

//    			(deleteItemIdList.length == 0) {
    				cartActionMessage = "削除する投稿が選択されていません";

    			}

//    			if (deleteItemIdList != null) {
//    				//削除対象の商品を削除
//    				for (int deleteItemId : iarray) {
//    					System.out.println(deleteItemId);
////    					bdbhList = new ArrayList<PostDataBeans>();
//    					session.setAttribute("deleteList", deleteItemId);
//    					session.setAttribute("thread", thread);
//    					request.getRequestDispatcher("/WEB-INF/jsp/postdeleteconfirm.jsp").forward(request, response);
//    				}
//
//    			}
//
//    			if (deleteItemIdList.length == 0) {
//    				cartActionMessage = "削除する商品が選択されていません";
//    			}

    			int id = (int) request.getAttribute("userId");
    			UserDAO UserDAO = new UserDAO();
    			UserDataBeans udb = UserDAO.findByUserInfo(id);

    			request.setAttribute("udb", udb);
    			request.setAttribute("cartActionMessage", cartActionMessage);
    			request.getRequestDispatcher("/WEB-INF/jsp/userdate.jsp").forward(request, response);

    		} catch (Exception e) {
    			e.printStackTrace();
    			session.setAttribute("errorMessage", e.toString());
    			response.sendRedirect("Error");
    		}
    	}
    }
