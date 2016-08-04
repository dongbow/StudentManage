package com.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sm.model.Student;
import com.sm.service.StudentService;
import com.sm.service.impl.StudentServiceImpl;
import com.sm.utils.StringUtils;

public class AddStudentServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stuid = request.getParameter("stuid").trim();
		String stuname = request.getParameter("stuname").trim();
		String stusex = request.getParameter("stusex").trim();
		String stuage = request.getParameter("stuage").trim();
		String stuclass = request.getParameter("stuclass").trim();
		String stuaddress = request.getParameter("stuaddress").trim();
		
		if(StringUtils.isNotBlank(stuid) && StringUtils.isNotBlank(stuname)
				&& StringUtils.isNotBlank(stusex)
				&& StringUtils.isNotBlank(stuage)
				&& StringUtils.isNotBlank(stuclass)
				&& StringUtils.isNotBlank(stuaddress)) {
			Student student = new Student();
			student.setStuId(stuid);
			student.setStuName(stuname);
			if("0".equals(stusex)){
				student.setStuSex("男");
			} else {
				student.setStuSex("女");
			}
			student.setStuAge(Integer.parseInt(stuage));
			student.setStuClass(stuclass);
			student.setStuAddress(stuaddress);
			
			StudentService studentService = new StudentServiceImpl();
			studentService.insertStudent(student);
			
		}
		
		response.sendRedirect("StudentListForm");
	}

}
