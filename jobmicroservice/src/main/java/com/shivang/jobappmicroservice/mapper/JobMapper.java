package com.shivang.jobappmicroservice.mapper;

import java.util.List;

import com.shivang.jobappmicroservice.dto.JobWithCompanyAndReviewDTO;
import com.shivang.jobappmicroservice.external.Company;
import com.shivang.jobappmicroservice.external.Review;
import com.shivang.jobappmicroservice.job.Job;

public class JobMapper {

    public static JobWithCompanyAndReviewDTO mapToJobWithCompanyDTO (
        Job job, 
        Company company,
        List<Review> reviews
    ) {
        JobWithCompanyAndReviewDTO jobWithCompanyAndReviewDTO = new JobWithCompanyAndReviewDTO();
        jobWithCompanyAndReviewDTO.setCompany(company);
        jobWithCompanyAndReviewDTO.setDescription(job.getDescription());
        jobWithCompanyAndReviewDTO.setLocation(job.getLocation());
        jobWithCompanyAndReviewDTO.setMaxSal(job.getMaxSal());
        jobWithCompanyAndReviewDTO.setMinSal(job.getMinSal());
        jobWithCompanyAndReviewDTO.setTitle(job.getTitle());
        jobWithCompanyAndReviewDTO.setId(job.getId());
        jobWithCompanyAndReviewDTO.setReview(reviews);
        return jobWithCompanyAndReviewDTO;

    }
}
