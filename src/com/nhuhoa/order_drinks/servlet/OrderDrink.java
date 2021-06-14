package com.nhuhoa.order_drinks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nhuhoa.order_drinks.bo.Drinks;
import com.nhuhoa.order_drinks.dao.DrinkDAO;
import com.nhuhoa.order_drinks.dao.OrderDAO;

/**
 * Servlet implementation class OrderDrink
 */
@WebServlet("/orderDrink")
public class OrderDrink extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDrink() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* String user_idStr=(String) request.getParameter("user_id"); */

		String idStr = (String) request.getParameter("drink_id");
		int drink_id = Integer.parseInt(idStr);
		DrinkDAO drinkDao = new DrinkDAO();
		Drinks drink = drinkDao.findById(drink_id);
		System.out.println(drink.getDrink_id());

		request.setAttribute("drink", drink);
		/* request.setAttribute("user", ); */

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/order.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("user_id") != null) {
			request.setCharacterEncoding("UTF-8");
			int user_id = (int) session.getAttribute("user_id");
			System.out.println(user_id);
			String drink_idStr = (String) request.getParameter("drink_id");
			int drink_id = Integer.parseInt(drink_idStr);

			String priceStr = (String) request.getParameter("price");
			double price = Double.parseDouble(priceStr);

			String quantityStr = (String) request.getParameter("quantity");
			int quantity = Integer.parseInt(quantityStr);

			double total = quantity * price;

			String comment = (String) request.getParameter("comment");

			OrderDAO orderDao = new OrderDAO();
			orderDao.insertOrder(drink_id, user_id, quantity, total, comment);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/payment.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("lỗi");
			request.setAttribute("errorMessage", "Please login!!");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
