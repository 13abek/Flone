package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.FeedbackService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbacksController {
    private FeedbackService feedbackService;

    @Autowired
    public FeedbacksController(FeedbackService feedbackService){
        this.feedbackService=feedbackService;
    }
    @PostMapping("/add")
    public Result add(Feedback feedback){
        return this.feedbackService.add(feedback);
    }
    @DeleteMapping("/delete")
    public Result delete(Feedback feedback){
     return    this.feedbackService.delete(feedback);
    }
    @GetMapping("/getall")
    public DataResult<List<Feedback>> getAll(){
        return this.feedbackService.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public DataResult<Feedback> findById(@PathVariable int id){
        return this.feedbackService.findById(id);
    }
    @PatchMapping("/update")
    public  Result update(Feedback feedback){
        return this.feedbackService.update(feedback);
    }
}
