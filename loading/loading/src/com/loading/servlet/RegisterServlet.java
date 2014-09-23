package com.loading.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loading.bean.User;
import com.loading.dao.Dao;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("GB2312");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		username=new String(username.getBytes("ISO-8859-1"),"GB2312");
		password=new String(password.getBytes("ISO-8859-1"),"GB2312");
		Dao dao = new Dao();

		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		System.out.println(username);
		
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		try {
			if (dao.register(user)) {
				response.sendRedirect("registerSuccess.jsp");
			} else {
				request.getRequestDispatcher("registerFailure.jsp").forward(
						request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
