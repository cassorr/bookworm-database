package App.Application.Controllers;

import App.Domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import App.Infrastructure.ReviewRepository;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewRepository reviewRepository;

    public ReviewController(@Autowired JdbcTemplate databaseConnection) {
        this.reviewRepository = new ReviewRepository(databaseConnection);
    }

    // GET: Retrieve all reviews
    @GetMapping("/")
    public List<Review> getReviews() {
        return this.reviewRepository.get();
    }

    // GET: Retrieve a review by ID
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable String id) throws Exception {
        return this.reviewRepository.get(id);
    }

    // POST: Write a new review
    @PostMapping("/")
    public void createReview(@RequestBody Review review) {
        this.reviewRepository.create(review);
    }

    // DELETE: Delete a review by ID
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable String id) {
        this.reviewRepository.delete(id);
    }

    // PUT: Update a review
    @PutMapping("/{id}")
    public void updateReview(@PathVariable String id, @RequestBody Review review) {
        this.reviewRepository.update(id, review);
    }
}
