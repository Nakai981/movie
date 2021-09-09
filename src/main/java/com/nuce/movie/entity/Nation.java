package com.nuce.movie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="nation")
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "nation",
            cascade = CascadeType.ALL,
            orphanRemoval = true ,
            fetch = FetchType.LAZY)
    private List<Movie> movies;

    private String nation_name;
    private boolean status;

}
