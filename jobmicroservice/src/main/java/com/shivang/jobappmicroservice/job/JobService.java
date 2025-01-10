package com.shivang.jobappmicroservice.job;

import java.util.List;

import com.shivang.jobappmicroservice.dto.JobWithCompanyAndReviewDTO;

public interface JobService {

    List<JobWithCompanyAndReviewDTO> findAll();
    void createJob(Job job);
    JobWithCompanyAndReviewDTO getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job j);
}