package App.Infrastructure;

import App.Domain.Review;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReviewRepository extends BaseRepository<Review> {

    public ReviewRepository(JdbcTemplate databaseConnection) {
        super(databaseConnection);
    }

    // Get all reviews
    @Override
    public List<Review> get() {
        String SQL = "SELECT Review_ID AS reviewID, User_ID AS userID, Book_ID AS bookID, " +
                "Review_Date AS reviewDate, Review_Text AS reviewText, Five_Star_Scale_Rating AS fiveStarScaleRating, " +
                "Spoiler_Warning AS spoilerWarning FROM REVIEWS;";
        return this.getDatabaseConnection().query(SQL, BeanPropertyRowMapper.newInstance(Review.class));
    }

    // Get a review by ID
    @Override
    public Review get(String id) throws Exception {
        String SQL = "SELECT Review_ID AS reviewID, User_ID AS userID, Book_ID AS bookID, " +
                "Review_Date AS reviewDate, Review_Text AS reviewText, Five_Star_Scale_Rating AS fiveStarScaleRating, " +
                "Spoiler_Warning AS spoilerWarning FROM REVIEWS WHERE Review_ID = ?;";
        List<Review> reviews = this.getDatabaseConnection().query(SQL, BeanPropertyRowMapper.newInstance(Review.class), id);

        if (reviews.isEmpty()) {
            throw new Exception("Review not found with ID: " + id);
        }

        return reviews.get(0);
    }

    // Create a new review
    @Override
    public void create(Review review) {
        String SQL = "INSERT INTO REVIEWS (User_ID, Book_ID, Review_Date, Review_Text, Five_Star_Scale_Rating, Spoiler_Warning) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
        this.getDatabaseConnection().update(SQL, review.getUserID(), review.getBookID(), review.getReviewDate(),
                review.getReviewText(), review.getFiveStarScaleRating(), review.isSpoilerWarning());
    }

    // Delete a review
    @Override
    public void delete(String id) {
        String SQL = "DELETE FROM REVIEWS WHERE Review_ID = ?;";
        this.getDatabaseConnection().update(SQL, id);
    }

    // Update a review
    @Override
    public void update(String id, Review review) {
        String SQL = "UPDATE REVIEWS SET Review_Text = ?, Five_Star_Scale_Rating = ?, Spoiler_Warning = ? " +
                "WHERE Review_ID = ?;";
        this.getDatabaseConnection().update(SQL, review.getReviewText(), review.getFiveStarScaleRating(),
                review.isSpoilerWarning(), id);
    }
}
