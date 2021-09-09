package com.nuce.movie.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "server_id",nullable = false)
    private Server server;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "episode_id",nullable = false)
    private Episode episode;

    private String message;
    private String link;

    private boolean status;

    @Transient
    private int movie_id;
}
