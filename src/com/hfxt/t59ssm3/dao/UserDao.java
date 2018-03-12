package com.hfxt.t59ssm3.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hfxt.t59ssm3.domain.User;
import com.hfxt.t59ssm3.util.Page;

public interface UserDao {
	
	public User getUserByUsername(String username);
	public List<User> getAllUsers();
	public int deleteUser(int id);
	public void addUser(User user);
	public User getUserInfoById(int id);
	public int updateUser(User user);
	public List<User> getUserListByConditon(User condition);
	public List<User> getUserListByPage(@Param("condition")User condition,@Param("page")Page page);
	public int getTotalCount(@Param("condition")User condition);
	/*public List<User> getUserListByPage(Map<Page,User> map);*/
	/*public List<User> getUserListByPage(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,
			@Param(value="status")int status,@Param("username")String username,@Param("password")String password);*/
}
