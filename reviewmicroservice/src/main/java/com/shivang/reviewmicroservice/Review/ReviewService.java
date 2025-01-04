package com.shivang.reviewmicroservice.Review;

import java.util.List;

public interface ReviewService {
 
    List<Review> getAllReviews(Long id);
    boolean addReview(Review review, Long id);
    Review getReview(Long reviewId);
    boolean updateReview(Long reviewId, Review review);
    boolean deleteReview(Long reviewId);    
}