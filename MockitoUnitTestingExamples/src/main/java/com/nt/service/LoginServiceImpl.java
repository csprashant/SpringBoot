package com.nt.service;

import com.nt.dao.ILoginDao;

public class LoginServiceImpl implements ILoginService {
	private ILoginDao loginDao;
	public LoginServiceImpl(ILoginDao loginDao) {
	this.loginDao=loginDao;	
	}
	@Override
	public boolean Login(String username, String pass) {
		System.out.println("Coming to Service class of Login method");
		if(username.equals("")|| pass.equals("") )
			throw new IllegalArgumentException();
		int count=loginDao.auntheticate(username, pass);
		if(count==0)
			return false;
		else 
			return true;

	
	}
}
