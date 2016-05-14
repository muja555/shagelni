package com.fbm.sha3ilni;

import java.io.Serializable;

/**
 * Created by Mojahed Dameri on 5/13/16.
 */
public class Worker implements Serializable {

    int id;
    String fullName;
    String userName;
    String email;
    String phoneNumber;
    String city;
    String address;
    String description;
    String image;
    int rateHour;
    int totalErnings;
    ReviewModel[] reviewModels;
    int stars;
    int starsVoters;
    double lat;
    double log;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getStarsVoters() {
        return starsVoters;
    }

    public void setStarsVoters(int starsVoters) {
        this.starsVoters = starsVoters;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getRateHour() {
        return rateHour;
    }

    public void setRateHour(int rateHour) {
        this.rateHour = rateHour;
    }

    public int getTotalErnings() {
        return totalErnings;
    }

    public void setTotalErnings(int totalErnings) {
        this.totalErnings = totalErnings;
    }

    public ReviewModel[] getReviewModels() {
        return reviewModels;
    }

    public void setReviewModels(ReviewModel[] reviewModels) {
        this.reviewModels = reviewModels;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
