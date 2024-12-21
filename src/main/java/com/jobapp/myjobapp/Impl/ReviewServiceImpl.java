package com.jobapp.myjobapp.Impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jobapp.myjobapp.Service.CompanyService;
import com.jobapp.myjobapp.Service.ReviewService;
import com.jobapp.myjobapp.model.Company;
import com.jobapp.myjobapp.model.Review;
import com.jobapp.myjobapp.repository.ReviewRespository;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRespository reviewRespository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRespository reviewRespository, CompanyService companyService) {
        this.reviewRespository = reviewRespository;
        this.companyService = companyService;

    }

    @Override
    public ResponseEntity<List<Review>> getAllReviews(Long id) {
        return ResponseEntity.ok(reviewRespository.findByCompanyId(id));
    }

    @Override
    public ResponseEntity<String> addReview(Review review, Long id) {

        Company c = companyService.getCompanyById(id).getBody();

        if(c != null) {
            review.setCompany(c);
            reviewRespository.save(review);
            return ResponseEntity.ok("Review added successfully");
        }
        else
            return new ResponseEntity<>("Reivew not added", HttpStatus.NOT_FOUND);

    }

    @Override
    public Review getReview(Long reviewId, Long companyId) {
        List<Review> reviews = reviewRespository.findByCompanyId(companyId);

        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId)).findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Long companyId, Review review) {
        if(companyService.getCompanyById(companyId) != null) {
            review.setCompany(companyService.getCompanyById(companyId).getBody());
            review.setId(reviewId);
            reviewRespository.save(review);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null 
        && reviewRespository.existsById(reviewId)) {
            
            //Getting the reviews and company it belongs to
            Review review = reviewRespository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            
            //Deleting review and references 
            company.getReviews().remove(reviewId);
            review.setCompany(null);

            //Updating company
            companyService.updateCompanyById(companyId, company);    
            reviewRespository.deleteById(reviewId);

            return true;
        }

        else
            return false;
    }

    
}
