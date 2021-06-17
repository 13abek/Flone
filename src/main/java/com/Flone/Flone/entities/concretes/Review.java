package com.Flone.Flone.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotEmpty
    private String name;

    @Email
    @NotBlank
    @NotEmpty
    private String email;

    @NotNull
    @NotBlank
    private double star;

    @Email
    @NotBlank
    @NotEmpty
    private String content;

    @ManyToOne()
    @JoinColumn(name = "productId")
    private Product product;
}
