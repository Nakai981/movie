package com.nuce.movie;

import com.nuce.movie.entity.Role;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.*;
import com.nuce.movie.services.CommentService;
import com.nuce.movie.servicesImpl.MovieServiceImpl;
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
    CommentService commentService;
    @Autowired
    UserRepository userRepository;
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
    @Test
    public void testDate(){
        String date1 = "2021-09-08 22:00:00";
        String date = "2021-09-01 09:33:58";
        String dateStart = "2021-03-14 09:33:58";
//        System.out.println(commentService.handlingDate(date));
//        System.out.println(commentService.handlingDate(date1));
//        System.out.println(commentService.handlingDate(dateStart));

    }
    @Test
    public void getMovie(){
        // TH load
//        System.out.println(commentService.getAllComment().get(0).getId());
////        System.out.println(commentService.getAllComment().size());
//
//        commentService.setSetting();
//
//        System.out.println(commentService.getAllComment().get(4).getId());

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.;
//        Date d = LocalDateTime.now();
//        System.out.println(dtf.format(now));
        String dateStart = "2012-03-14 09:33:58";

        String dateStop = "2012-03-14 10:34:59";

        // Custom date format

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = null;

        Date d2 = null;

        try {

            d1 = format.parse(dateStart);

            d2 = format.parse(dateStop);

        } catch (ParseException e) {

        }

        // Get msec from each, and subtract.

        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000;

        long diffMinutes = diff / (60 * 1000);

        long diffHours = diff / (60 * 60 * 1000);

        System.out.println("Số giây : " + diffSeconds + " seconds.");

        System.out.println("Số phút: " + diffMinutes + " minutes.");

        System.out.println("Số giờ: " + diffHours + " hours.");
    }
}
