package com.joga10.api_joga10.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "court_reservations")
public class CourtReservation {
    @Id
    private String id;
    private String courtId;
    private String userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCourtId() { return courtId; }
    public void setCourtId(String courtId) { this.courtId = courtId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
}
