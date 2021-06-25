package com.Flone.Flone.entities.concretes;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "homes")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "upper_title")
    @NotBlank
    @NotNull
    private String upperTitle;

    @Column(name = "title")
    @NotBlank
    @NotNull
    private String title;

    @OneToMany(mappedBy = "home")
    private List<HomeSlider> homeSliders;

    public  Home(){

    }

    public Home(int id, String upperTitle, String title) {
        this.id = id;
        this.upperTitle = upperTitle;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpperTitle() {
        return upperTitle;
    }

    public void setUpperTitle(String upperTitle) {
        this.upperTitle = upperTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHomeSliders(List<HomeSlider> homeSliders) {
        this.homeSliders = homeSliders;
    }
}
