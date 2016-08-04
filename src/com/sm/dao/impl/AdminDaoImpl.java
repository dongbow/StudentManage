package com.sm.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sm.dao.AdminDao;
import com.sm.database.DBPool;
import com.sm.model.Admin;

public class AdminDaoImpl implements AdminDao {

	public Admin loginCheck(Admin admin) {
		Connection conn = DBPool.createConnection();
		Statement stmt = DBPool.createStatement(conn);
		StringBuilder sql = new StringBuilder();
		sql.append("select * from admin as ad where ad.loginname = '")
		   .append(admin.getLoginName()).append("' and ad.password = '")
		   .append(admin.getPassword()).append("'");
		ResultSet rs = DBPool.executeQuery(stmt, sql.toString());
		Admin resultAdmin = null;
		try {
			while(rs.next()){
				resultAdmin = new Admin();
				resultAdmin.setNickName(rs.getString("nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBPool.close(conn, stmt, rs);
		return resultAdmin;
	}

}
