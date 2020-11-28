package com.houx.basic.dao;

import org.springframework.stereotype.Repository;

import com.houx.basic.pojo.Role;

/**
 * @Author: HouX
 * @Date: 2020/11/24
 * @Description:
 */

//@Repository
public interface RoleDao {

	public Role getRole(Long id);
}