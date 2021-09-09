package com.nuce.movie.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String episode_name;
    private int episode_view;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "movie_id",nullable = false)
    private Movie movie;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Message> messages;

    private boolean status;

    @Transient
    private boolean check_session = false;
}
