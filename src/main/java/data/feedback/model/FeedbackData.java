package data.feedback.model;

import java.util.List;

public class FeedbackData {

    private Long id;
    private String name;
    private String email;
    private int rating;
    private String source;
    private List<String> likedFeatures;
    private String message;

    public FeedbackData() {
    }

    public FeedbackData(String name, String email, int rating, String source, List<String> likedFeatures, String message) {
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.source = source;
        this.likedFeatures = likedFeatures;
        this.message = message;
    }

    public FeedbackData(Long id, String name, String email, int rating, String source, List<String> likedFeatures, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.source = source;
        this.likedFeatures = likedFeatures;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getLikedFeatures() {
        return likedFeatures;
    }

    public void setLikedFeatures(List<String> likedFeatures) {
        this.likedFeatures = likedFeatures;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
