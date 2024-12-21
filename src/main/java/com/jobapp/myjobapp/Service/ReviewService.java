package com.jobapp.myjobapp.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jobapp.myjobapp.model.Review;

public interface ReviewService {
 
    ResponseEntity<List<Review>> getAllReviews(Long id);
    ResponseEntity<String> addReview(Review review, Long id);
    Review getReview(Long reviewId, Long companyId);
    boolean updateReview(Long reviewId, Long companyId, Review review);
    boolean deleteReview(Long companyId, Long reviewId);    
}