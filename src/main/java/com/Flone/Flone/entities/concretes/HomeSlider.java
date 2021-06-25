package com.Flone.Flone.entities.concretes;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "home_sliders")
public class HomeSlider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name="type")
    @NotNull
    @NotBlank
    private String type;
    @Lob
    private byte[] data;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name ="home_id")
    private Home home;
    public HomeSlider(){

    }
    public HomeSlider(int id, String name, String type,Home home) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.home=home;
    }
    public void addHome(@NotNull Home home){
        this.home=home;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
