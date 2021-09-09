package com.nuce.movie.servicesImpl;

import com.nuce.movie.entity.Comment;
import com.nuce.movie.entity.User;
import com.nuce.movie.repositories.CommentRepository;
import com.nuce.movie.repositories.UserRepository;
import com.nuce.movie.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    private int ided = -1;

    @Override
    public List<Comment> getAllComment(){
        // Get all comment from 1 to 5
        List<Comment> cmts =  commentRepository.getAllComments(PageRequest.of(0,5));


        for(Comment cmt: cmts){
            cmt.setDate(this.handlingDate(cmt.getCreate_at()));
        }

        // compare id
//        if(ided != cmts.get(0).getId()){

            // value from array[0]
            ided = cmts.get(0).getId();

            //swap
            this.swap(cmts);
            return cmts;
//        }
//        return null;
    }

    @Override
    public void setSetting(){
        this.ided = -1;
    }

    @Override
    public void addComment(String username, String comment, int id){
        Comment cm = new Comment();
        cm.setComment(comment);
        cm.setUsername(username);

        User u = userRepository.findById(id).get();
        cm.setUser(u);

        LocalDateTime now = LocalDateTime.now();
        cm.setCreate_at(now);

        cm.setStatus(true);
        commentRepository.save(cm);
    }

    public void swap(List<Comment> cmts){
         Collections.reverse(cmts);
    }
    @Override
    public String handlingDate(LocalDateTime dateTime){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //Now
        LocalDateTime now = LocalDateTime.now();

        // format
        String now_str = dtf.format(now);
        String present_str = dtf.format(dateTime);


        Date now_date = null;
        Date present_date = null;

        try {

            now_date = simpleDateFormat.parse(now_str);

            present_date = simpleDateFormat.parse(present_str);

        } catch (ParseException e) {

        }
        if(now_date != null || present_date != null){
            long diff = now_date.getTime() - present_date.getTime();

            long diff_minutes = diff / (60 * 1000);

            long diff_hours = diff / (60 * 60 * 1000);
            long diff_day = diff / (60 * 60 * 1000*24);
            long diff_week = Math.round(diff_day) / 7L;
            long diff_month = Math.round(Math.round(diff_day) / 30L);
            long diff_year = Math.round(Math.round(diff_month) / 12L);

            if(diff_hours <= 1L) return diff_minutes+"mins ago";
            else
            if(diff_hours >= 1L && diff_hours <24L) return diff_hours+"hours ago";
            else
            if(diff_hours >= 24L && diff_hours <24L*7L) return diff_day+"days ago";
            else
            if(diff_day >= 1L && diff_day <30L) return diff_week+"week ago";
            else
            if(diff_day >= 30L && diff_day <30L*30) return diff_month+"month ago"+diff_day+"/"+diff;
            else
            if(diff_month > 12L) return diff_year+"year ago";
        }


        return null;
    }



}
