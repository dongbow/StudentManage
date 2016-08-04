package com.sm.form.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sm.bean.Page;
import com.sm.model.Student;
import com.sm.service.StudentService;
import com.sm.service.impl.StudentServiceImpl;

public class StudentListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String pageNo = request.getParameter("page");
		int nowPage = 0;
		if(pageNo == null || "1".equals(pageNo)){
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(pageNo);
		}
		StudentService studentService = new StudentServiceImpl();
		Page page = new Page();
		page.setNowPage(nowPage);
		page.setTotalCount(studentService.count());
		List<Student> studentList = studentService.findAllStudent(page);
		request.setAttribute("studentList", studentList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/views/studentlist.jsp").forward(request, response);
	}

}
