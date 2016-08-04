package com.sm.form.servlet;

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

public class UpdateStudentForm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		StudentService studentService = new StudentServiceImpl();
		Student student = studentService.findStudent(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("WEB-INF/views/update.jsp").forward(request, response);
	}

}
