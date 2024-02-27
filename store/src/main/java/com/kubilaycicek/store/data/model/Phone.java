package com.kubilaycicek.store.data.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String phoneName;

    @Column(name = "brand", nullable = false)
    private String phoneBrand;
}