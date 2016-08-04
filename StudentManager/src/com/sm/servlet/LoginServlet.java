package com.sm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sm.model.Admin;
import com.sm.service.AdminService;
import com.sm.service.impl.AdminServiceImpl;
import com.sm.utils.MD5Utils;
import com.sm.utils.StringUtils;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String loginName = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(password)) {
			AdminService adminService = new AdminServiceImpl();
			Admin admin = adminService.loginCheck(loginName, MD5Utils.getMD5String(password));
			if(admin != null) {
				request.getSession().setAttribute("admin", admin);
				response.sendRedirect("StudentListForm");
			} else {
				request.setAttribute("loginMsg", "用户名或密码错误");
				request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("loginMsg", "用户名或密码不能为空");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
