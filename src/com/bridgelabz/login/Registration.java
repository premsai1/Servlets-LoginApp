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
 * @purpose : Srevlets implements Regestration details and checks a condition that 
 * if the mail is already registred it dosn't allow to register
 */

@WebServlet("/registration")
public class registration extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String mail = request.getParameter("mail");
		loginDao dao = new loginDao();
		try {
			if (dao.duplicate(mail) == false) {
				dao.add(first_name, username, password, address, contact, mail);
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("welcome.jsp");
			} else

			{
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Email Id Already Existing');");
				out.println("location='registeration.jsp';");
				out.println("</script>");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
