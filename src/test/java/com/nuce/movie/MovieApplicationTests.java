package com.nuce.movie;

import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.Nation;
import com.nuce.movie.repositories.MovieRepository;
import com.nuce.movie.servicesImpl.MovieServiceImpl;
import com.nuce.movie.servicesImpl.NationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.List;

@SpringBootTest
class MovieApplicationTests {


    private final String PASS = "phan";

    @Test
    void contextLoads() {
    }
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Test
//    public void nation(){
//        System.out.println(">> PasswordEncoder: "     +passwordEncoder.encode(PASS));
//
//        System.out.println(">> MD5: " + DigestUtils.md5DigestAsHex(PASS.getBytes()));
//
//        PasswordEncoder pass = NoOpPasswordEncoder.getInstance();
//        System.out.println(">> NoOp: " + pass.encode(PASS));
//
//        PasswordEncoder passOne = new LdapShaPasswordEncoder();
//        System.out.println(">> Ldap: "+passOne.encode(PASS));
//
//        PasswordEncoder passTwo = new BCryptPasswordEncoder(15);
//        System.out.println(">>BCrypt: "+passTwo.encode(PASS));
//
//    }

}
