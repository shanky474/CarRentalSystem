package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoImpl;
import model.Authentication;
import model.Customer;

public class LoggedInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Authentication user = (Authentication) session.getAttribute("user");
		Customer[] customer = new DaoImpl("javarnd", "root", "root").getCustomerInfo(user);
		session.setAttribute("customer", customer);
		request.getRequestDispatcher("/mainpages/loggedin.jsp").include(request, response);
	}

}
