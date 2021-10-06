package com.nuce.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int day;

    private int price;

    private boolean status;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<PurchaseDetail> purchaseDetails;

    @Transient
    private String days_left;
    @Transient
    private String email;
}
