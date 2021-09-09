package com.nuce.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime create_at;

    private String username;
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    private User user;

    private boolean status;

    @Transient
    private String date;

}
