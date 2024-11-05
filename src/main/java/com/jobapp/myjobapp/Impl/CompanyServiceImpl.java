package com.jobapp.myjobapp.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jobapp.myjobapp.Service.CompanyService;
import com.jobapp.myjobapp.model.Company;
import com.jobapp.myjobapp.model.Job;
import com.jobapp.myjobapp.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public ResponseEntity<Company> getCompanyById(Long id) {
        for(Company c : companyRepository.findAll()) {
            if (c.getId().equals(id)) {
                return ResponseEntity.ok().body(c);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> addCompany(Company company) {
        if(companyRepository.findById(company.getId()).isPresent())
            return ResponseEntity.badRequest().body("Company with id: " + company.getId() + " already present");
        else
        {
            companyRepository.save(company);
            return new ResponseEntity<>("Company with same id already exists", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<String> deleteCompanyById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCompanyById'");
    }

    @Override
    public ResponseEntity<String> updateCompanyById(Long id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if(companyOptional.isPresent()) {
            Company existingCompany = companyOptional.get();
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
            existingCompany.setJobs(company.getJobs());
            existingCompany.setId(company.getId());
            companyRepository.save(existingCompany);
            return ResponseEntity.ok().body("Company updated successfully");
        }

        return ResponseEntity.notFound().build();
    }
    
}