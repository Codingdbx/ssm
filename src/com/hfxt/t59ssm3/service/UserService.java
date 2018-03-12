package com.hfxt.t59ssm3.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hfxt.t59ssm3.domain.User;
import com.hfxt.t59ssm3.util.Page;

public interface UserService {

	public User checkLogin(String username,String password);
	public List<User> getAllUsers();
	public int deleteUser(int id);
	public void addUser(User user);
	public User getUserInfoById(int id);
	public int updateUser(User user);
	public List<User> getUserListByConditon(User condition);
	public List<User> getUserListByPage(User condition,Page page);
	public int getTotalCount(User condition);
	/*public List<User> getUserListByPage(Map<Page,User> map);*/
	/*public List<User> getUserListByPage(int pageIndex,int pageSize,User condition);*/
	/*public List<User> getUserListByPage(@Param(value="pageIndex")int pageIndex,@Param(value="pageSize")int pageSize,
			@Param(value="status")int status,@Param(value="username")String username,@Param(value="password")String password);*/
}
