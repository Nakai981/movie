package com.nuce.movie.controllers;

import com.nuce.movie.entity.Comment;
import com.nuce.movie.entity.CommentApi;
import com.nuce.movie.repositories.CommentRepository;
import com.nuce.movie.servicesImpl.CommentServiceImpl;
import liquibase.pro.packaged.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MCommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/comment")
    public ResponseEntity<List<Comment>> getComment(){
        return new ResponseEntity<>(commentService.getAllComment(), HttpStatus.OK);
    }

    @GetMapping("/comment/setting")
    public String setComment(){
        commentService.setSetting();
        return "";
    }

    @PostMapping(value ="/comment/add",consumes = "application/json", produces = "application/json")
    public String addComment(@RequestBody CommentApi comment, HttpSession session){
        String name = (String)session.getAttribute("name");
        if(name != null){
            int user_session_id = (int)session.getAttribute("user_id");
            commentService.addComment(comment.getUsername(),comment.getComment(),user_session_id);
        }
        return "null";
    }
}
