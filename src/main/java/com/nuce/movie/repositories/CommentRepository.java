package com.nuce.movie.repositories;

import com.nuce.movie.entity.Comment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query("select cm from Comment cm where cm.status = true order by cm.id desc")
    List<Comment> getAllComments(PageRequest pageRequest);

}
