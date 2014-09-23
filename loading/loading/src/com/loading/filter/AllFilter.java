package com.loading.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AllFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r = (HttpServletRequest) request;
		HttpSession session = r.getSession();
		String requestURI = r.getRequestURI();
	/*	System.out.println(requestURI);
		System.out.println(r.getRequestURL());*/
		if (requestURI.endsWith("index.jsp")|| requestURI.endsWith("register.jsp")||requestURI.endsWith("LoginServlet")||requestURI.endsWith("RegisterServlet")) {
			chain.doFilter(request, response);
			return;
		}
		if (null == session.getAttribute("username")) {
			((HttpServletResponse) response).sendRedirect("index.jsp");
			return;
		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
