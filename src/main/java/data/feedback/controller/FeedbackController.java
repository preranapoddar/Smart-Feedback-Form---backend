package data.feedback.controller;

import data.feedback.entity.Feedback;
import data.feedback.model.FeedbackData;
import data.feedback.repository.FeedbackRepository;
import data.feedback.service.FeedbackService;
import data.feedback.util.ValidatorUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public ResponseEntity<FeedbackData> saveFeedback(@RequestBody FeedbackData request) {
        if(request == null || !ValidatorUtil.isValidEmail(request.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity(
                feedbackService.submitFeedback(request), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FeedbackData>> getAllFeedbacks(HttpServletRequest request) {
        return new ResponseEntity(
                feedbackService.getAllFeedbacks(request), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        return new ResponseEntity (
                feedbackService.getFeedbackById(id), HttpStatus.OK);
    }
}
