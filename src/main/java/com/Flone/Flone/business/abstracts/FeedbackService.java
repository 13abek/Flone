package com.Flone.Flone.business.abstracts;

import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Feedback;

import javax.xml.crypto.Data;
import java.util.List;

public interface FeedbackService {
    DataResult<List<Feedback>> getAll();
    DataResult<Feedback> findById(int id);
    Result add(Feedback feedback);
    Result delete(Feedback feedback);
    Result update(Feedback feedback);

}
