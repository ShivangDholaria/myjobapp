package com.jobapp.myjobapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.myjobapp.Service.ReviewService;
import com.jobapp.myjobapp.model.Review;

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
@RequestMapping(path = "/company/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getCompanyReviews(@PathVariable Long companyId) {
        return reviewService.getAllReviews(companyId);
    }
    
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review review, @PathVariable Long companyId) {
        return reviewService.addReview(review, companyId);
    }
    
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId, @PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getReview(reviewId, companyId), HttpStatus.OK);
    }
    
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @PathVariable Long companyId, @RequestBody Review review) {
        //TODO: process PUT request
        if(reviewService.updateReview(reviewId, companyId, review) == true)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review updated unsuccessfully", HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean isDeleted = reviewService.deleteReview(companyId, reviewId);

        if(isDeleted)
            return new ResponseEntity<>("Review Deleted successfully", HttpStatus.OK);
        else    
            return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
    }
}