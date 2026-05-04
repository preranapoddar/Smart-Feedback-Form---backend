package data.feedback.service;

import data.feedback.entity.Feedback;
import data.feedback.model.FeedbackData;
import data.feedback.repository.FeedbackRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserService userService;

    public FeedbackData submitFeedback(FeedbackData feedbackData) {
        if (feedbackData == null) return null;

        Feedback feedback = new Feedback();
        feedback.setName(feedbackData.getName());
        feedback.setEmail(feedbackData.getEmail());
        feedback.setRating(feedbackData.getRating());
        feedback.setMessage(feedbackData.getMessage());
        feedback.setSource(feedbackData.getSource());
        feedback.setCreatedAt(LocalDateTime.now());

        String likedFeatures = "";
        if (feedbackData.getLikedFeatures() != null)
            for (String feature : feedbackData.getLikedFeatures()) {
                if (likedFeatures.isEmpty()) likedFeatures = feature;
                else likedFeatures += "," + feature;
            }

        feedback.setLikedFeatures(likedFeatures);
        feedbackRepository.save(feedback);
        return feedbackData;
    }

    public List<Feedback> getAllFeedbacks(HttpServletRequest request) {
        String token = request.getHeader("Token");

        if (!userService.validateToken(token))
            throw new RuntimeException("Unauthorized request");

        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }
}