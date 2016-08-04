package com.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sm.service.StudentService;
import com.sm.service.impl.StudentServiceImpl;
import com.sm.utils.StringUtils;

public class DeleteStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			StudentService studentService = new StudentServiceImpl();
			studentService.deleteStudent(id);
			response.sendRedirect("StudentListForm");
		}
	}

}
