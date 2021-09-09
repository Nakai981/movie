package com.nuce.movie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "server")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String server_name;
    private String server_config;

    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Message> messages;

    private boolean status;
}
