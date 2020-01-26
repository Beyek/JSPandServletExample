package com.test.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter()
public class AuthenticationFilter2 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//pre-processing
		System.out.println("AuthenticationFilter2.doFilter");
		HttpServletRequest request = (HttpServletRequest)arg0;
		if(request.getRequestURI().startsWith("/viewProfile")){
			HttpSession session = request.getSession();
			if(session.getAttribute("username")==null){

				request.getRequestDispatcher("/html/login.jsp").forward(request, arg1);
			}
			
		}else if(request.getRequestURI().startsWith("/getProduct")){
			// todo own task
		}
		
		arg2.doFilter(request, arg1);
		//post-processing

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
