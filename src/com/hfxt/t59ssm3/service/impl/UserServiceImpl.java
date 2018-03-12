package com.hfxt.t59ssm3.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfxt.t59ssm3.dao.UserDao;
import com.hfxt.t59ssm3.domain.User;
import com.hfxt.t59ssm3.service.UserService;
import com.hfxt.t59ssm3.util.Page;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User checkLogin(String username, String password) {
		User user=userDao.getUserByUsername(username);
		if(user!=null && user.getPassword().equals(password)){
			return user;
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public void addUser(User user) {
		 userDao.addUser(user);
	}

	@Override
	public User getUserInfoById(int id) {
		return userDao.getUserInfoById(id);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	/*@Override
	public List<User> getUserListByPage(int pageIndex, int pageSize,
			int status, String username, String password) {
		return userDao.getUserListByPage(pageIndex, pageSize, status, username, password);
	}*/
	
	@Override
	public List<User> getUserListByConditon(User condition) {
		return userDao.getUserListByConditon(condition);
	}
	
	@Override
	public List<User> getUserListByPage(User condition,Page page) {
		return userDao.getUserListByPage(condition,page);
	}

	@Override
	public int getTotalCount(User condition) {
		return userDao.getTotalCount(condition);
	}


/*	@Override
	public List<User> getUserListByPage(Map<Page, User> map) {
		return userDao.getUserListByPage(map);
	}*/

/*	@Override
	public List<User> getUserListByPage(int pageIndex, int pageSize,User condition) {
		return userDao.getUserListByPage(pageIndex, pageSize, condition);
	}*/

}
