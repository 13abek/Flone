package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbacksController {
    private FeedbackService feedbackService;

    @Autowired
    public FeedbacksController(FeedbackService feedbackService){
        this.feedbackService=feedbackService;
    }
}
