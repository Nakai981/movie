package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Role;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.RoleRepository;
import com.nuce.movie.repositories.UserRepository;
import com.nuce.movie.services.ConnectionSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacebookConnectionSignUp implements ConnectionSignUp {

//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//
//
//    @Override
//    public String execute(Connection<?> connection) {
//        User user = new User();
//        user.setEmail();
//        user.setFullname(connection.getDisplayName());
//
//        List<Role> roles = new ArrayList<>();
//        roles.add(roleRepository.findById(3).get());
//        user.setRoles(roles);
//
//        user.setStatus(true);
//
//        user.setPassword(randomAlphabetic(8));
//        userRepository.save(user);
//        return user.getUsername();
//    }

}
