package com.nuce.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movie_name;
    @Temporal(TemporalType.DATE)
    private Date release_year;
    private int total_episodes;
    private String movie_introduction;
    private int movie_length;
    private String movie_trailer;
    private String movie_image;
    private String movie_comment;
    private String movie_type;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "nation_id",nullable = false)
    @JsonIgnore
    private Nation nation;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<MovieDetail> movieDetails;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Episode> episodes;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="category_detail",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnore
    private List<Category> categories;

    private boolean status;

    @Transient
    public String getStringMovieName(){
        if(this.movie_name.length()<=19){
            return this.movie_name;
        }
        return  this.movie_name.substring(0,17)+"...";
    }
    @Transient
    public String getStringMovieIntroduce(){
        if(this.movie_introduction.length()<=70){
            return this.movie_introduction;
        }
        return  this.movie_introduction.substring(0,70)+"...";
    }

    @Transient
    private String view;

    @Transient
    private String rate;

    @Transient
    private String episode;

    @Transient String nation_name;

    @Transient private List<String> category_name;

    @Transient private boolean nominate = false;

}
