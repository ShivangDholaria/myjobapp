package com.jobapp.myjobapp.Impl;

import java.util.List;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jobapp.myjobapp.Service.JobService;
import com.jobapp.myjobapp.model.Job;
import com.jobapp.myjobapp.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobRepository.findAll());
    }

    @Override
    public ResponseEntity<String> createJob(Job job) {
        
        jobRepository.save(job);
        return new ResponseEntity<>("Job created", HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Job> getJobById(Long id) {
        
        if(jobRepository.findById(id).isPresent())
            return new ResponseEntity<>(jobRepository.findById(id).get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteJobById(Long id) {
        
        try {
            jobRepository.deleteById(id);
            return new ResponseEntity<>("Job removed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> updateJobById(Long id, Job job) {
        
        Optional<Job> joboOptional = jobRepository.findById(id);

        if(joboOptional.isPresent())
        {
            Job j = joboOptional.get();
            j.setDescription(job.getDescription());
            j.setLocation(job.getLocation());
            j.setMaxSal(job.getMaxSal());
            j.setMinSal(job.getMinSal());
            j.setTitle(job.getTitle());
            jobRepository.save(j);
            return ResponseEntity.ok().body("Job updated successfully");
        }
        
        return ResponseEntity.notFound().build();
    }

}
