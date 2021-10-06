package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Role;
import com.nuce.movie.repositories.RoleRepository;
import com.nuce.movie.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    @Override
    public String getRoleName(int id){
        return roleRepository.getRoleNameByRoleID(id);
    }

    @Override
    public boolean getIdByRoleIDAndUserId(int role_id, int user_id){
        String name = roleRepository.getIdByRoleIDAndUserId(role_id, user_id);
        if(name == null) return true;
        else return false;
    }
    @Override
    public Integer getRoleNameByUserId( int user_id){
        List<Integer> role_id_list = roleRepository.getRoleNameByUserId(user_id);
        for(Integer i: role_id_list){
            if(i == 5){
                return 4;
            }
            if(i == 1){
                return i;
            }
            if(i == 2){
                return i;
            }
        }
        return 0;
    }

}
