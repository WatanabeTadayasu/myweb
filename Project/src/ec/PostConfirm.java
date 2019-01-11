package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.DeliveryMethodDataBeans;
import dao.DeliveryMethodDAO;

/**
 * Servlet implementation class PostConfirm
 */
@WebServlet("/PostConfirm")
public class PostConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			//選択された配送方法IDを取得
			int inputThreadCategoryId = Integer.parseInt(request.getParameter("thread_category_id"));
			//選択されたIDをもとに配送方法Beansを取得
			//DeliveryMethodDataBeans userSelectDMB = DeliveryMethodDAO.getDeliveryMethodDataBeansByID(inputDeliveryMethodId);
			DeliveryMethodDataBeans dmdb = DeliveryMethodDAO.getDeliveryMethodDataBeansByID(inputThreadCategoryId);
//			//買い物かご
//			ArrayList<ItemDataBeans> cartIDBList = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
//			//合計金額
//			int totalPrice = EcHelper.getTotalItemPrice(cartIDBList) + dmdb.getPrice();
//
			int threadCategoryId = dmdb.getId();

			String inputThreadTitle = request.getParameter("thread_title");
			String inputThreadText = request.getParameter("thread_text");

			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setUserId((int) session.getAttribute("userId"));
			bdb.setThreadTitle(inputThreadTitle);
			bdb.setThreadText(inputThreadText);
			bdb.setThreadCategoryId(threadCategoryId);

//			int userId = (int) session.getAttribute("userId");

//			DeliveryMethodDataBeans selectDMB = new DeliveryMethodDataBeans();
//			bdb.setDeliveryMethodId(userSelectDMB.getId());
//			bdb.setDeliveryMethodName(userSelectDMB.getName());
//			bdb.setDeliveryMethodPrice(userSelectDMB.getPrice());

			String validationMessage = "";

			// 入力チェック
			if (inputThreadTitle.equals("") || inputThreadText.equals("")) {
				validationMessage += "タイトル、本文を入力して下さい。<br>";
			}

			// バリデーションエラーメッセージがないなら確認画面へ
			if (validationMessage.length() == 0) {
				//購入確定で利用
				session.setAttribute("bdb", bdb);
				request.setAttribute("userSelectDMB", dmdb);
				request.getRequestDispatcher("/WEB-INF/jsp/postconfirm.jsp").forward(request, response);
			} else {
				session.setAttribute("bdb", bdb);
				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("Buy");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
