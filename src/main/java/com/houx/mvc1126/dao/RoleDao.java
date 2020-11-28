package com.houx.mvc1126.dao;

import com.houx.mvc1126.pojo.Role;
import com.houx.mvc1126.pojo.RoleParams;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: HouX
 * @Date: 2020/11/26
 * @Description:
 */
@Repository
public interface RoleDao {

    public int insertRole(Role role);

    public Role getRole(Long id);

    public List<Role> findRoles(RoleParams roleParams);

    public int deleteRole(Long id);
}
