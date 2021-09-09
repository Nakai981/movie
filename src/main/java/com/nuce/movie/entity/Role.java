package com.nuce.movie.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role_name;


    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    private boolean status;

    @Override
    public String getAuthority() {
        return role_name;
    }
}
