package com.jobapp.myjobapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jobapp.myjobapp.Service.CompanyService;
import com.jobapp.myjobapp.model.Company;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/company")
public class CompanyController {
    
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Company>> getCompanies() {
        return companyService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        
        return companyService.updateCompanyById(id, company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        return companyService.deleteCompanyById(id);
    }

     @GetMapping("/{id}")
     public ResponseEntity<Company> getCompanyById(@RequestParam Long id) {
         return companyService.getCompanyById(id);
     }
         
}
