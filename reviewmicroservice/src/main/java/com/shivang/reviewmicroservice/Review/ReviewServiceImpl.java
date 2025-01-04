package com.shivang.reviewmicroservice.Review;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRespository reviewRespository;

    public ReviewServiceImpl(ReviewRespository reviewRespository) {
        this.reviewRespository = reviewRespository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRespository.findByCompanyId(companyId );
        
        return reviews;
    }

    @Override
    public boolean addReview(Review review, Long id) {

        if(id != null && review != null) {
            review.setCompanyId(id);
            reviewRespository.save(review);
            return true;
        }
        else
            return false;

    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewRespository.findById(reviewId).orElse(null); 
    }

    @Override
    public boolean updateReview(Long reviewId, Review review) {
        Review review_1 = reviewRespository.findById(reviewId).orElse(null);

        if(review_1 != null) {
            review_1.setTitle(review.getTitle());
            review_1.setDescription(review.getDescription());
            review_1.setRating(review.getRating());
            review_1.setCompanyId(review.getCompanyId());
            reviewRespository.save(review_1);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {

        Review review = reviewRespository.findById(reviewId).orElse(null);

        if(review != null) {
            reviewRespository.delete(review);
            return true;
        }
        else
            return false;
    }

    
}
