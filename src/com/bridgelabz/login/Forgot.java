package com.bridgelabz.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.login.dao.loginDao;

/**
 * @author Premsai Manthani
 * @Purpose : In this Servlet class if the user and mail is already existing in the database and
 * both new password and confirm fields matches then only it updates the password of the user.
 * In case of any failure it display the error message.
 */
@WebServlet("/forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter obj = response.getWriter();
		String uname = request.getParameter("username");
		String mail = request.getParameter("mail");
		String news = request.getParameter("news");
		String confirm = request.getParameter("confirm");
		loginDao dao = new loginDao();

		if (dao.recover(uname, mail)) {
			if (news.equals(confirm)) {
				dao.reset(news, mail);
				obj.println("password updated");
				response.sendRedirect("login.jsp");
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('password field doesnt match');");
				out.println("location='forgot.jsp';");
				out.println("</script>");
			}
		} else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('entered username are mail field doesnt match');");
			out.println("location='forgot.jsp';");
			out.println("</script>");
		}
	}
}