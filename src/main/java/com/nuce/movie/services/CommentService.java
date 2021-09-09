package com.nuce.movie.services;

import com.nuce.movie.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();

    void setSetting();


    void addComment(String username, String comment, int id);

    String handlingDate(LocalDateTime dateTime);
}
