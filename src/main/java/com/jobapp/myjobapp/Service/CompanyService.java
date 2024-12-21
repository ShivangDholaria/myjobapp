package com.jobapp.myjobapp.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jobapp.myjobapp.model.Company;

public interface CompanyService {
    ResponseEntity<List<Company>> findAll();
    ResponseEntity<Company> getCompanyById(Long id);
    ResponseEntity<String> addCompany(Company company);
    ResponseEntity<String> deleteCompanyById(Long id);
    ResponseEntity<String> updateCompanyById(Long id, Company company);

}
