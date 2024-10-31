package com.jobapp.myjobapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jobapp.myjobapp.Service.JobService;
import com.jobapp.myjobapp.model.Job;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/jobs")
public class JobController {   

    private JobService js;
    
    public JobController(JobService js) {
        this.js = js;
    }


    @GetMapping
    public ResponseEntity<List<Job>> finAll() {
        return js.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id) {
        return js.getJobById(id);
    }
    

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job jobObj) {

        return js.createJob(jobObj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {

        return js.deleteJobById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {
        return js.updateJobById(id, job);
    }


}
