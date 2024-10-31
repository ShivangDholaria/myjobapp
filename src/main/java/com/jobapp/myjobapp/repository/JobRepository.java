package com.jobapp.myjobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.myjobapp.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
}
