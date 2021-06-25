package com.Flone.Flone.dataAccess.abstracts;

import com.Flone.Flone.entities.concretes.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeDao extends JpaRepository<Home,Integer> {
    Home findById (int id);
}
