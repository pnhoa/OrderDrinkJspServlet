package com.nhuhoa.order_drinks.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhuhoa.order_drinks.bo.Drinks;
import com.nhuhoa.order_drinks.bo.Orders;
import com.nhuhoa.order_drinks.bo.Users;
import com.nhuhoa.order_drinks.dao.DrinkDAO;
import com.nhuhoa.order_drinks.dao.OrderDAO;
import com.nhuhoa.order_drinks.dao.UserDAO;
import com.nhuhoa.order_drinks.modal.OrderView;

/**
 * Servlet implementation class OrderList
 */
@WebServlet("/orderList")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderList() {
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
		OrderDAO orderDao = new OrderDAO();
		ArrayList<Orders> orderList = orderDao.getAllOrders();
		ArrayList<OrderView> orderViewList = new ArrayList<OrderView>();
		for (Orders inf : orderList) {
			OrderView orderView = new OrderView();
			orderView.setOrder_id(inf.getOrder_id());

			int drink_id = inf.getDrink_id();
			DrinkDAO drinkDao = new DrinkDAO();
			Drinks drink = drinkDao.findById(drink_id);
			orderView.setDrink_name(drink.getDrink_name());

			int user_id = inf.getUser_id();
			UserDAO userDao = new UserDAO();
			Users user = userDao.findById(user_id);
			orderView.setUsername(user.getUsername());
			orderView.setEmail(user.getEmail());
			orderView.setPhone(user.getPhone());
			orderView.setAddress(user.getAddress());
			orderView.setTotal(inf.getTotal());
			orderView.setComment(inf.getComment());
			orderView.setOrder_date(inf.getOrder_date());

			orderViewList.add(orderView);
		}

		request.setAttribute("orderViewList", orderViewList);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orderList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
