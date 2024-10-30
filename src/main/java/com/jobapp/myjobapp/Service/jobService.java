package com.jobapp.myjobapp.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jobapp.myjobapp.model.Job;

public interface jobService {

    ResponseEntity<List<Job>> findAll();
    ResponseEntity<String> createJob(Job job);
    ResponseEntity<Job> getJobById(Long id);
    ResponseEntity<String> deleteJobById(Long id);
}