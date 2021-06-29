package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.FeedbackService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> add(Feedback feedback){
        return ResponseEntity.ok(this.feedbackService.add(feedback));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(Feedback feedback){
     return ResponseEntity.ok(   this.feedbackService.delete(feedback));
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.feedbackService.getAll());
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return ResponseEntity.ok(this.feedbackService.findById(id));
    }
    @PatchMapping("/update")
    public  ResponseEntity<?> update(Feedback feedback){
        return ResponseEntity.ok(this.feedbackService.update(feedback));
    }
}
