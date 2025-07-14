package com.joga10.api_joga10.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "player_ratings")
public class PlayerRating {
    @Id
    private String id;
    private String playerId;
    private String reviewerId;
    private int rating; // 1 a 5
    private String comment;

    // Getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPlayerId() { return playerId; }
    public void setPlayerId(String playerId) { this.playerId = playerId; }
    public String getReviewerId() { return reviewerId; }
    public void setReviewerId(String reviewerId) { this.reviewerId = reviewerId; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
