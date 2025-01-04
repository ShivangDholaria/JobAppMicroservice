package com.shivang.reviewmicroservice.Review;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getCompanyReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
 
        if(reviewService.addReview(review, companyId))
            return new ResponseEntity<>("Review saved Successfully", HttpStatus.OK);
 
        return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);

    }
    
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {

        return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
    }
    
    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {

        if(reviewService.updateReview(reviewId, review))
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review updated unsuccessfully", HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview( @PathVariable Long reviewId) {
        boolean isDeleted = reviewService.deleteReview(reviewId);

        if(isDeleted)
            return new ResponseEntity<>("Review Deleted successfully", HttpStatus.OK);
        else    
            return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
    }
}