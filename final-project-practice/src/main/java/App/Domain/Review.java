package App.Domain;

import java.util.Date;

public class Review {
    private int reviewID;           // Review_ID
    private int userID;             // User_ID
    private int bookID;             // Book_ID
    private Date reviewDate;        // Review_Date
    private String reviewText;      // Review_Text
    private int fiveStarScaleRating; // Five_Star_Scale_Rating
    private boolean spoilerWarning; // Spoiler_Warning

    // Getters and Setters
    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getFiveStarScaleRating() {
        return fiveStarScaleRating;
    }

    public void setFiveStarScaleRating(int fiveStarScaleRating) {
        this.fiveStarScaleRating = fiveStarScaleRating;
    }

    public boolean isSpoilerWarning() {
        return spoilerWarning;
    }

    public void setSpoilerWarning(boolean spoilerWarning) {
        this.spoilerWarning = spoilerWarning;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", userID=" + userID +
                ", bookID=" + bookID +
                ", reviewDate=" + reviewDate +
                ", reviewText='" + reviewText + '\'' +
                ", fiveStarScaleRating=" + fiveStarScaleRating +
                ", spoilerWarning=" + spoilerWarning +
                '}';
    }
}
