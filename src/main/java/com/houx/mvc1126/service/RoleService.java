package com.houx.mvc1126.service;

import com.houx.mvc1126.pojo.Role;
import com.houx.mvc1126.pojo.RoleParams;

import java.util.List;

/**
 * @Author: HouX
 * @Date: 2020/11/24
 * @Description:
 */

public interface RoleService {

	public int insertRoles(List<Role> roleList);

	public Role getRole(Long id);

	public List<Role> findRoles(RoleParams roleParams);

	public int deleteRoles(List<Long> idList);

	public int insertRole(Role role);
}

