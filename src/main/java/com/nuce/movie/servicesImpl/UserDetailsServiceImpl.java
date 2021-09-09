package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = userRepository.getUserByEmail(s);
        if(u == null){
            throw new UsernameNotFoundException("Username not found !");
        }
        return new org.springframework.security.core.userdetails.User(s,u.getPassword(),u.getRoles());
    }
}
