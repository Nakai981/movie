package com.nuce.movie;

import com.nuce.movie.entity.Advertisement;
import com.nuce.movie.entity.Role;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.*;
import com.nuce.movie.services.CommentService;
import com.nuce.movie.servicesImpl.*;
import org.h2.util.MathUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class JunitMovie {
    @Autowired
    AdvertisementServiceImpl advertisementService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    MovieRepository movieService;
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    MessageRepository messageRepository;
    @Test
    public void div_returnZero(){
       String fullname = "Phan Huy Hoang";
       System.out.println(fullname.length());
    }
    @Test
    public void date() throws Exception{
        String da = "2021-08-12";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(da);
        System.out.println(date1);
    }
    @Autowired
    private EmailServiceImpl emailService;
    @Test
    public void testDate(){
        emailService.sendEmail("hoang88362@nuce.edu.vn","98989","OTP");
    }

}
