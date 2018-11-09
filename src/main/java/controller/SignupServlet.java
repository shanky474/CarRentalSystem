package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoImpl;
import model.Authentication;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Authentication auth = new Authentication();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		auth.setUsername(username);
		auth.setPassword(password);
		auth.setRole("User");
		auth.setBlacklisted("No");
		boolean status = new DaoImpl("javarnd", "root", "root").save(auth);
		System.out.println(username + password + status);
		if (status) {
			request.getRequestDispatcher("/index.jsp").include(request, response);
			out.println("<a style=\"color:blue;\">User added!</a>");
		} else {
			request.getRequestDispatcher("/mainpages/signup.jsp").include(request, response);
			out.println("<a style=\"color:blue;\">Error! Please try again</a>");
		}
	}

}
