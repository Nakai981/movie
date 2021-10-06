package com.nuce.movie;

import com.nuce.movie.entity.Category;
import com.nuce.movie.entity.Movie;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.*;
import com.nuce.movie.services.EpisodeService;
import com.nuce.movie.services.ServerService;
import com.nuce.movie.services.UserService;
import com.nuce.movie.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication

public class MovieApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Autowired UserServiceImpl userService;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(userService.filterUser("Id","",1,true,0).size());

    }
}
