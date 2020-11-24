package com.houx.dao;

import org.springframework.stereotype.Repository;

import com.houx.pojo.Role;

/**
 * @Author: HouX
 * @Date: 2020/11/24
 * @Description:
 */

@Repository
public interface RoleDao {
	
	public Role getRole(Long id);
}
