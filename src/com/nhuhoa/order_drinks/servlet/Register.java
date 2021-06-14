package com.nhuhoa.order_drinks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhuhoa.order_drinks.dao.UserDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
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
		String username = (String) request.getParameter("username");
		String email = (String) request.getParameter("email");
		String phone = (String) request.getParameter("phone");
		String address = (String) request.getParameter("address");
		String password = (String) request.getParameter("password");

		UserDAO userDao = new UserDAO();
		boolean checkUsername = userDao.isUsernameExists(username);
		boolean checkEmail = userDao.isEmailExists(email);
		boolean checkPhone = userDao.isPhoneExists(phone);
		if (checkUsername == false && checkEmail == false && checkPhone == false) {
			userDao.insertUser(username, email, phone, address, password);
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			if (checkEmail == true || checkPhone == true || checkUsername == true) {
				request.setAttribute("errorMessage", "Sorry! Have a same information. Please create another account");
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/register.jsp");
				dispatcher.forward(request, response);
			}

		}

	}

}
