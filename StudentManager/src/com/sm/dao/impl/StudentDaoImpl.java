package com.sm.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sm.bean.Page;
import com.sm.dao.StudentDao;
import com.sm.database.DBPool;
import com.sm.model.Student;

public class StudentDaoImpl implements StudentDao {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public List<Student> findAllStudent(Page page) {
		conn = DBPool.createConnection();
		stmt = DBPool.createStatement(conn);
		String sql = "select * from student limit " + page.getStart() + ", " + page.getPageSize();
		rs = DBPool.executeQuery(stmt, sql);
		List<Student> list = new ArrayList<Student>();
		try {
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setStuId(rs.getString("stuid"));
				student.setStuName(rs.getString("stuname"));
				student.setStuSex(rs.getString("stusex"));
				student.setStuAge(rs.getInt("stuage"));
				student.setStuClass(rs.getString("stuclass"));
				student.setStuAddress(rs.getString("stuaddress"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBPool.close(conn, stmt, rs);
		return list;
	}

	public Student findStudent(String id) {
		conn = DBPool.createConnection();
		stmt = DBPool.createStatement(conn);
		String sql = "select * from student where id = '" + id + "'";
		rs = DBPool.executeQuery(stmt, sql);
		Student student = new Student();
		try {
			while(rs.next()) {
				student.setId(rs.getInt("id"));
				student.setStuId(rs.getString("stuid"));
				student.setStuName(rs.getString("stuname"));
				student.setStuSex(rs.getString("stusex"));
				student.setStuAge(rs.getInt("stuage"));
				student.setStuClass(rs.getString("stuclass"));
				student.setStuAddress(rs.getString("stuaddress"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public int insertStudent(Student student) {
		conn = DBPool.createConnection();
		stmt = DBPool.createStatement(conn);
		StringBuilder sql = new StringBuilder();
		sql.append("insert into student (stuid,stuname,stusex,stuage,stuclass,stuaddress) ")
		   .append("values('").append(student.getStuId()).append("','")
		   .append(student.getStuName()).append("','")
		   .append(student.getStuSex()).append("','")
		   .append(student.getStuAge()).append("','")
		   .append(student.getStuClass()).append("','")
		   .append(student.getStuAddress()).append("')");
		int row = DBPool.executeUpdate(stmt, sql.toString());
		DBPool.close(conn, stmt, null);
		return row;
	}

	public int updateStudent(Student student) {
		conn = DBPool.createConnection();
		stmt = DBPool.createStatement(conn);
		StringBuilder sql = new StringBuilder();
		sql.append("update student set stuid = '").append(student.getStuId()).append("',")
		   .append("stuname = '").append(student.getStuName()).append("',")
		   .append("stuSex = '").append(student.getStuSex()).append("',")
		   .append("stuAge = '").append(student.getStuAge()).append("',")
		   .append("stuclass = '").append(student.getStuClass()).append("',")
		   .append("stuaddress = '").append(student.getStuAddress())
		   .append("' where id = '").append(student.getId()).append("'");
		int row = DBPool.executeUpdate(stmt, sql.toString());
		DBPool.close(conn, stmt, null);
		return row;
	}

	public int deleteStudent(String id) {
		conn = DBPool.createConnection();
		stmt = DBPool.createStatement(conn);
		StringBuilder sql = new StringBuilder();
		sql.append("delete from student where id = '").append(id).append("'");
		int row = DBPool.executeUpdate(stmt, sql.toString());
		DBPool.close(conn, stmt, rs);
		return row;
	}

	public List<Student> searchByWay(String flag, String keyword) {
		conn = DBPool.createConnection();
		stmt = DBPool.createStatement(conn);
		StringBuilder sql = new StringBuilder();
		sql.append("select * from student as s where s.").append(flag)
		   .append(" like '%").append(keyword).append("%'");
		rs = DBPool.executeQuery(stmt, sql.toString());
		List<Student> list = new ArrayList<Student>();
		try {
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setStuId(rs.getString("stuid"));
				student.setStuName(rs.getString("stuname"));
				student.setStuSex(rs.getString("stusex"));
				student.setStuAge(rs.getInt("stuage"));
				student.setStuClass(rs.getString("stuclass"));
				student.setStuAddress(rs.getString("stuaddress"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBPool.close(conn, stmt, rs);
		return list;
	}

	public int count() {
		conn = DBPool.createConnection();
		stmt = DBPool.createStatement(conn);
		String sql = "select count(*) as count from student";
		rs = DBPool.executeQuery(stmt, sql);
		int count = 0;
		try {
			if(rs.next()){   
				count = rs.getInt("count");   
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
