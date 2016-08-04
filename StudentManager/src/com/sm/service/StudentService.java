package com.sm.service;

import java.util.List;

import com.sm.bean.Page;
import com.sm.model.Student;

public interface StudentService {

	public List<Student> findAllStudent(Page page);
	
	public Student findStudent(String id);
	
	public int insertStudent(Student student);
	
	public int updateStudent(Student student);
	
	public int deleteStudent(String id);

	public List<Student> searchByWay(String way, String keyword);
	
	public int count();
	
}
