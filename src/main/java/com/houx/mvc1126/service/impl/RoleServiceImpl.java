package com.houx.mvc1126.service.impl;


import com.houx.mvc1126.dao.RoleDao;
import com.houx.mvc1126.pojo.Role;
import com.houx.mvc1126.pojo.RoleParams;
import com.houx.mvc1126.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Role> findRoles(RoleParams roleParams) {
        return roleDao.findRoles(roleParams);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int deleteRoles(List<Long> idList) {
        int count = 0;
        for (Long id : idList) {
            count += roleDao.deleteRole(id);
        }
        return count;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertRoles(List<Role> roleList) {
        int count = 0;
        for (Role role : roleList) {
            count += roleDao.insertRole(role);
        }
        return count;
    }

    @Override
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }

}