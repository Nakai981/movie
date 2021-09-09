package com.nuce.movie.repositories;

import com.nuce.movie.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r.role_name from Role r join r.users u where u.id = ?1")
    public List<String> getAllNameByUserId(int id);

    @Query("select r.role_name from Role r where r.id = ?1")
    public String getRoleNameByRoleID(int id);

    @Query("select r.role_name from Role r join r.users u where r.id = ?1 and u.id=?2")
    public String getIdByRoleIDAndUserId(int role_id,int user_id);

}
