package com.shivang.jobappmicroservice.job;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivang.jobappmicroservice.clients.CompanyClient;
import com.shivang.jobappmicroservice.clients.ReviewClient;
import com.shivang.jobappmicroservice.dto.JobWithCompanyAndReviewDTO;
import com.shivang.jobappmicroservice.external.Company;
import com.shivang.jobappmicroservice.external.Review;
import com.shivang.jobappmicroservice.mapper.JobMapper;

import org.springframework.web.client.RestTemplate;

@Service
public class JobServiceImpl implements JobService{

    private JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    private CompanyClient companyClient;
    private ReviewClient reviewClient;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<JobWithCompanyAndReviewDTO> findAll() {
        
        List<Job> jobs = jobRepository.findAll();
        
        return jobs.stream().map(this::covertToDto).collect(Collectors.toList());
    }
    
    public JobWithCompanyAndReviewDTO covertToDto(Job job) {
        
        Company company = companyClient.getCompany(job.getCompanyId());

        List<Review> reviews = reviewClient.getReview(job.getCompanyId()); 

        JobWithCompanyAndReviewDTO jwcarDto = JobMapper.mapToJobWithCompanyDTO(job, company, reviews);
        
        return jwcarDto;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobWithCompanyAndReviewDTO getJobById(Long id) {
        
        return covertToDto(jobRepository.findById(id).orElse(null));
    }

    @Override
    public boolean deleteJobById(Long id) {
        
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false ;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        
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
            return true;
        }
        
        return false;
    }

}
