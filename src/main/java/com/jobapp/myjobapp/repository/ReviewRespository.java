package com.jobapp.myjobapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.myjobapp.model.Review;

public interface ReviewRespository extends JpaRepository<Review, Long>{
    List<Review> findByCompanyId(Long companyId);
}
