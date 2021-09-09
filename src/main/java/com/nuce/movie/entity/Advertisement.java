package com.nuce.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Advertisement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cooperation_company;

    private String banner;

    private int location;

    private LocalDateTime created_at;

    private LocalDateTime end_at;

    private boolean status;

}
