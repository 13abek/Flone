package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.FeedbackService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.core.utilities.Results.SuccessDataResult;
import com.Flone.Flone.core.utilities.Results.SuccessResult;
import com.Flone.Flone.dataAccess.abstracts.FeedbackDao;
import com.Flone.Flone.entities.concretes.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackManager implements FeedbackService {
    private FeedbackDao feedbackDao;
    @Autowired
    public FeedbackManager(FeedbackDao feedbackDao){
        this.feedbackDao=feedbackDao;
    }


    @Override
    public DataResult<List<Feedback>> getAll() {
        return new SuccessDataResult<>(this.feedbackDao.findAll(),"Feedback lists!");
    }

    @Override
    public DataResult<Feedback> findById(int id) {
        return null;
    }

    @Override
    public Result add(Feedback feedback) {
        this.feedbackDao.save(feedback);
        return new SuccessResult("Feedback added!");
    }

    @Override
    public Result delete(Feedback feedback) {
        this.feedbackDao.delete(feedback);
        return new SuccessResult("feedback has been deleted!");
    }

    @Override
    public Result update(Feedback feedback) {
        return null;
    }
}
