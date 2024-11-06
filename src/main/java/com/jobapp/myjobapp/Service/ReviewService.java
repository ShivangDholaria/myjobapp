package com.jobapp.myjobapp.Service;

import java.util.List;

import com.jobapp.myjobapp.model.Review;

public interface ReviewService {
 
    List<Review> getAllReviews(Long id);
}