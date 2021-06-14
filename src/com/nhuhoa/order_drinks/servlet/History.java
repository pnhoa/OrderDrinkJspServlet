package com.nhuhoa.order_drinks.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nhuhoa.order_drinks.bo.Drinks;
import com.nhuhoa.order_drinks.bo.Orders;
import com.nhuhoa.order_drinks.dao.DrinkDAO;
import com.nhuhoa.order_drinks.dao.OrderDAO;
import com.nhuhoa.order_drinks.modal.OrderHistory;

/**
 * Servlet implementation class History
 */
@WebServlet("/history")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public History() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		int user_id =(int) session.getAttribute("user_id");
		OrderDAO orderDao =new OrderDAO();
		ArrayList<Orders> orderList = orderDao.getUserOrders(user_id);
		ArrayList<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();
		for(Orders inf :orderList ) {
			OrderHistory orderHistory =new OrderHistory();
			
			int drink_id = inf.getDrink_id();
			DrinkDAO drinkDao = new DrinkDAO();
			Drinks drink = drinkDao.findById(drink_id);
			orderHistory.setDrink_name(drink.getDrink_name());
			orderHistory.setImage(drink.getImage());
			orderHistory.setPrice(drink.getPrice());
			orderHistory.setQuantity(inf.getQuantity());
			orderHistory.setTotal(inf.getTotal());
			orderHistory.setOrder_date(inf.getOrder_date());
			orderHistoryList.add(orderHistory);
		}
		request.setAttribute("orderHistoryList", orderHistoryList);
		RequestDispatcher dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/views/history.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
