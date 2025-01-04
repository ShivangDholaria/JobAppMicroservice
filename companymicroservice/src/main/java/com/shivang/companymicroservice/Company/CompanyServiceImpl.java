package com.shivang.companymicroservice.Company;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> addCompany(Company company) {
        companyRepository.save(company);
        return new ResponseEntity<>("Company added", HttpStatus.OK);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else 
            return false;
    }

    @Override
    public boolean updateCompanyById(Long id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if(companyOptional.isPresent()) {
            Company existingCompany = companyOptional.get();
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
            // existingCompany.setId(company.getId());
            companyRepository.save(existingCompany);
            return true;
        }

        return false;
    }
    
}
