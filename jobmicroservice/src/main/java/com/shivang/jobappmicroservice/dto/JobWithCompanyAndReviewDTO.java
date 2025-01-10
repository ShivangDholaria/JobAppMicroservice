package com.shivang.jobappmicroservice.dto;

import java.util.List;

import com.shivang.jobappmicroservice.external.Company;
import com.shivang.jobappmicroservice.external.Review;

public class JobWithCompanyAndReviewDTO {
    private Long id;
    private String title;
    private String description;
    private String minSal;
    private String maxSal;
    private String location;    
    private Company company;
    private List<Review> review;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMinSal() {
        return minSal;
    }
    public void setMinSal(String minSal) {
        this.minSal = minSal;
    }
    public String getMaxSal() {
        return maxSal;
    }
    public void setMaxSal(String maxSal) {
        this.maxSal = maxSal;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public List<Review> getReview() {
        return review;
    }
    public void setReview(List<Review> review) {
        this.review = review;
    }

    
}
