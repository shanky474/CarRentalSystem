package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoImpl;
import model.Authentication;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Authentication auth = new Authentication();
		DaoImpl access = new DaoImpl("javarnd", "root", "root");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		auth.setUsername(username);
		auth.setPassword(password);
		Authentication auth1 = access.getUserInfo(auth);
		try {
			if (auth1 != null && auth1.getBlacklisted().equals("No") && auth1.getRole().equals("User")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", auth1);
				request.getRequestDispatcher("LoggedInServlet").include(request, response);
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("index.jsp").include(request, response);
				out.println("Wrong credentials!");
			}
		} catch (Exception e) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.jsp").include(request, response);
			out.println("Wrong credentials!");
		}

	}

}
