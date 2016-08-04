package com.sm.filter;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {
	
    public static final String index_page = "index.jsp";
    public static final String login_page = "LoginForm";
    public static final String loginaction_page = "LoginServlet";
    public static final String logout_page = "LogoutForm";
    
    public void destroy(){
      System.out.println("destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException{

        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession s = req.getSession();
        
        if(req.getRequestURI().endsWith(index_page) 
        		|| req.getRequestURI().endsWith(login_page)
        		|| req.getRequestURI().endsWith(logout_page)
        		|| req.getRequestURI().endsWith(loginaction_page)){
            filterChain.doFilter(request, response);
            System.out.println("默认允许的页面放行");
            return ;
        }
        
        if(null == s.getAttribute("admin")){
            System.out.println("未登录，跳转登录页");
            ((HttpServletResponse)response).sendRedirect(login_page);
            return;
        } else {
        	System.out.println("已经登录，放行");
            filterChain.doFilter(request, response);
        }
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
       System.out.println("init");
    }

}
