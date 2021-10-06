package com.nuce.movie.services;

import com.nuce.movie.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();

    String getRoleName(int id);

    boolean getIdByRoleIDAndUserId(int role_id, int user_id);
    public Integer getRoleNameByUserId( int user_id);
}
