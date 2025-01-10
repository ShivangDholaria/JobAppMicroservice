package com.shivang.jobappmicroservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivang.jobappmicroservice.external.Review;

@FeignClient(name = "reviewmicroservice")
public interface ReviewClient {
    
    @GetMapping("/reviews")
    List<Review> getReview(@RequestParam("companyId") Long companyId);
}
