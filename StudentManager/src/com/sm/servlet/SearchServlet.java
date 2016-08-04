package com.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sm.model.Student;
import com.sm.service.StudentService;
import com.sm.service.impl.StudentServiceImpl;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String way = request.getParameter("way");
		String keyword = request.getParameter("keyword");
		keyword = new String(keyword.getBytes("iso-8859-1"),"utf-8");
		
		StudentService studentService = new StudentServiceImpl();
		List<Student> studentList = studentService.searchByWay(way, keyword);
		request.setAttribute("studentList", studentList);
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("WEB-INF/views/studentlist.jsp").forward(request, response);
	}

}
