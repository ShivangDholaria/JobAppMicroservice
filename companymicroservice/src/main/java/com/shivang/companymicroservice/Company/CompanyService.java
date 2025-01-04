package com.shivang.companymicroservice.Company;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CompanyService {
    List<Company> getAllCompany();
    Company getCompanyById(Long id);
    ResponseEntity<String> addCompany(Company company);
    boolean deleteCompanyById(Long id);
    boolean updateCompanyById(Long id, Company company);

}
