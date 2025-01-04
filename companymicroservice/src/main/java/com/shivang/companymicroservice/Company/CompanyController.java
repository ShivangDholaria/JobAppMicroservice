package com.shivang.companymicroservice.Company;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Company>> getCompanies() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.addCompany(company);

        return new ResponseEntity<>("Company added Successfully", HttpStatus.OK);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        companyService.updateCompanyById(id, company);

        return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompanyById(id);

        if(isDeleted)
            return new ResponseEntity<>("Company deleted Successfully", HttpStatus.OK);
        
        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        
        Company company = companyService.getCompanyById(id);

        if(company != null)
            return new ResponseEntity<>(company, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
         
}
