package com.Flone.Flone.dataAccess.abstracts;

import com.Flone.Flone.entities.concretes.HomeSlider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeSliderDao extends JpaRepository<HomeSlider,Integer> {
    HomeSlider findById(int id);
}
