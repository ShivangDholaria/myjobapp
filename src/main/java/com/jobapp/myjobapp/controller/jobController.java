package com.jobapp.myjobapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jobapp.myjobapp.Service.jobService;
import com.jobapp.myjobapp.model.Job;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class jobController {   

    private jobService js;
    
    public jobController(jobService js) {
        this.js = js;
    }


    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> finAll() {
        return js.findAll();
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id) {
        return js.getJobById(id);
    }
    

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job jobObj) {

        return js.createJob(jobObj);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {

        return js.deleteJobById(id);
    }
}
