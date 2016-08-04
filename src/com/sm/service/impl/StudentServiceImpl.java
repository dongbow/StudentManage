package com.sm.service.impl;

import java.util.List;

import com.sm.bean.Page;
import com.sm.dao.StudentDao;
import com.sm.dao.impl.StudentDaoImpl;
import com.sm.model.Student;
import com.sm.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
	}
	
	public List<Student> findAllStudent(Page page) {
		return studentDao.findAllStudent(page);
	}

	public Student findStudent(String id) {
		return studentDao.findStudent(id);
	}

	public int insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public int deleteStudent(String id) {
		return studentDao.deleteStudent(id);
	}

	public List<Student> searchByWay(String way, String keyword) {
		String flag = null;
		if("0".equals(way)){
			flag = "stuid";
		}else{
			flag = "stuname";
		}
		return studentDao.searchByWay(flag, keyword);
	}

	public int count() {
		return studentDao.count();
	}

}
