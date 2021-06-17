package com.Flone.Flone.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product_colors")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank
    @NotNull
    private String name;

    @OneToMany(mappedBy = "productColor")
    private List<Product> products;
}
