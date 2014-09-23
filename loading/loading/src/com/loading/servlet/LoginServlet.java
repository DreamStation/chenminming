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

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
			response.setContentType("text/html");
			request.setCharacterEncoding("GB2312");
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			username=new String(username.getBytes("ISO-8859-1"),"GB2312");
			password=new String(password.getBytes("ISO_8859-1"),"GB2312");
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			
			Dao dao=new Dao();
			
			try{
				if(dao.login(user)){
					HttpSession session=request.getSession();
					request.setAttribute("username", username);
					request.setAttribute("username", username);
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					session.setMaxInactiveInterval(10);//“‘√Îº∆À„
					request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
//					response.sendRedirect("loginSuccess.jsp");
				}
				else{
					response.sendRedirect("index.jsp");
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
	}

}
