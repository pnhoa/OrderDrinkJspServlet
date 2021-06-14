package com.nhuhoa.order_drinks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhuhoa.order_drinks.dao.DrinkDAO;
import com.nhuhoa.order_drinks.untils.FileUpdateUntil;

/**
 * Servlet implementation class InsertDrink
 */
@WebServlet("/insertDrink")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 100)
public class InsertDrink extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertDrink() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/insertDrink.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String drink_name = (String) request.getParameter("drink_name");
		String type = (String) request.getParameter("type");
		String description = (String) request.getParameter("description");
		String priceStr = (String) request.getParameter("price");

		String imagePath = FileUpdateUntil.saveImage(request);
		double price = Double.parseDouble(priceStr);
		DrinkDAO drinkDao = new DrinkDAO();
		drinkDao.insertDrink(drink_name, type, description, price, imagePath);

		response.sendRedirect(request.getContextPath() + "/administration");

	}

}
