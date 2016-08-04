package com.sm.service.impl;

import com.sm.dao.AdminDao;
import com.sm.dao.impl.AdminDaoImpl;
import com.sm.model.Admin;
import com.sm.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	
	public AdminServiceImpl() {
		this.adminDao = new AdminDaoImpl();
	}
	
	public Admin loginCheck(String loginName, String password) {
		Admin admin = new Admin();
		admin.setLoginName(loginName);
		admin.setPassword(password);
		return adminDao.loginCheck(admin);
	}

}
