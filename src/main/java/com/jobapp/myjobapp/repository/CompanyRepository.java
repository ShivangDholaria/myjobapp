package com.jobapp.myjobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.myjobapp.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
}
