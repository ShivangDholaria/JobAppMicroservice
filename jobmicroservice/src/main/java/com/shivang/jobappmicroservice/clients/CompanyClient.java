package com.shivang.jobappmicroservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shivang.jobappmicroservice.external.Company;

@FeignClient(name = "companymicroservice")
public interface CompanyClient {
    @GetMapping("/company/{companyId}")
    Company getCompany(@PathVariable("companyId") Long companyId);
}
