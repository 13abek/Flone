package com.Flone.Flone.dataAccess.abstracts;

import com.Flone.Flone.entities.concretes.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDao extends JpaRepository<Feedback,Integer> {
    Feedback findById(int id);
}
