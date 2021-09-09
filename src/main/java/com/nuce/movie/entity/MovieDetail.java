package com.nuce.movie.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movie_detail")
public class MovieDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float rate;
    private boolean follow;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "movie_id",nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private boolean status;

}
