package com.houx.service.impl;

import com.houx.dao.RoleDao;
import com.houx.pojo.Role;
import com.houx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao = null;
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Role getRole(Long id) {
		return roleDao.getRole(id);
	}

}
