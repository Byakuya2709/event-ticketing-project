/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.event.request;

/**
 *
 * @author admin
 */
public class BookingRequest {
    Long eventId;
    String userId;
    Double ticketPrice;
    String day;
    String ticketPosition;
    String ticketDuration;
    String ticketZone;
    String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketZone() {
        return ticketZone;
    }

    public void setTicketZone(String ticketZone) {
        this.ticketZone = ticketZone;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTicketPosition() {
        return ticketPosition;
    }

    public void setTicketPosition(String ticketPosition) {
        this.ticketPosition = ticketPosition;
    }

    public String getTicketDuration() {
        return ticketDuration;
    }

    public void setTicketDuration(String ticketDuration) {
        this.ticketDuration = ticketDuration;
    }
    
}
