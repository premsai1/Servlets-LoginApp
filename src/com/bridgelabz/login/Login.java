package com.bridgelabz.login;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.login.dao.loginDao;
@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");

		loginDao dao = new loginDao();

		try {
			if (dao.check(username, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("Welcome.jsp");
			} else {
				response.sendRedirect("Login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
