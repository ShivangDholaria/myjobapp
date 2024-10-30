package com.jobapp.myjobapp.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jobapp.myjobapp.Service.jobService;
import com.jobapp.myjobapp.model.Job;

@Service
public class jobServiceImpl implements jobService{

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobs);
    }

    @Override
    public ResponseEntity<String> createJob(Job job) {
        
        if(job.getId() == null) {
            job.setId(++nextId);
        }
        else {
            for(Job j : jobs)
            {
                if(j.getId() == job.getId())
                    job.setId(++nextId);
            }
        }
        jobs.add(job);

        return new ResponseEntity<>("Job created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Job> getJobById(Long id) {
        
        for(Job j : jobs)
            if(j.getId().equals(id))
                return new ResponseEntity<>(j, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteJobById(Long id) {
        for(Job j : jobs)
        {
            if(j.getId().equals(id))
            {
                jobs.remove(j);
                return new ResponseEntity<>("Job removed successfully", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }

}
