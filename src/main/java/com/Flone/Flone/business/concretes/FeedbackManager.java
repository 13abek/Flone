package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.FeedbackService;
import com.Flone.Flone.core.utilities.Results.*;
import com.Flone.Flone.core.utilities.emailValidation.EmailValidationService;
import com.Flone.Flone.dataAccess.abstracts.FeedbackDao;
import com.Flone.Flone.entities.concretes.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackManager implements FeedbackService {
    private FeedbackDao feedbackDao;
    private EmailValidationService emailValidationService;
    @Autowired
    public FeedbackManager(FeedbackDao feedbackDao,EmailValidationService emailValidationService){
        this.feedbackDao=feedbackDao;
        this.emailValidationService=emailValidationService;
    }


    @Override
    public DataResult<List<Feedback>> getAll() {
        return new SuccessDataResult<>(this.feedbackDao.findAll(),"Feedback lists!");
    }

    @Override
    public DataResult<Feedback> findById(int id) {
        return new SuccessDataResult<Feedback>(this.feedbackDao.findById(id),"Feedback found!");
    }
    @Override
    public Result add(Feedback feedback) {
        if (!this.emailValidationService.validate(feedback.getEmail())){
            return new ErrorResult("Invalid Email!,please try again");
        }
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
    Feedback updateToFeedback=this.feedbackDao.findById(feedback.getId());
    updateToFeedback.setEmail(feedback.getEmail());
    updateToFeedback.setName(feedback.getName());
    updateToFeedback.setSubject(feedback.getSubject());
    updateToFeedback.setMessage(feedback.getMessage());
    this.feedbackDao.save(updateToFeedback);
        return new SuccessResult("Feedback Updated !");
    }
}
