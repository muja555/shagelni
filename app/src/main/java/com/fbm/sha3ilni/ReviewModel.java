package com.fbm.sha3ilni;

import java.io.Serializable;

/**
 * Created by Mojahed Dameri on 5/13/16.
 */
public class ReviewModel implements Serializable{

    int stars;
    String image;
    String title;
    String comment;

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
