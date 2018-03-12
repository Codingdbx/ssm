package com.hfxt.t59ssm3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfxt.t59ssm3.dao.RoleDao;
import com.hfxt.t59ssm3.domain.Role;
import com.hfxt.t59ssm3.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	
	@Override
	public List<Role> getAllRoleName() {
		return roleDao.getAllRoleName();
	}

}
