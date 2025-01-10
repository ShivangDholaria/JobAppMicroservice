package com.shivang.jobappmicroservice.job;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.shivang.jobappmicroservice.dto.JobWithCompanyAndReviewDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/jobs")
public class JobController {   

    private JobService js;
    
    public JobController(JobService js) {
        this.js = js;
    }


    @GetMapping
    public ResponseEntity<List<JobWithCompanyAndReviewDTO>> finAll() {
        return ResponseEntity.ok(js.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobWithCompanyAndReviewDTO> findJobById(@PathVariable Long id) {
        JobWithCompanyAndReviewDTO jobWithCompanyAndReviewDTO = js.getJobById(id);
        if(jobWithCompanyAndReviewDTO != null)
            return new ResponseEntity<>(jobWithCompanyAndReviewDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job jobObj) {
        js.createJob(jobObj);
        return new ResponseEntity<>("Job added Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean isDeleted = js.deleteJobById(id);

        if(isDeleted)
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {
        boolean isUpdated = js.updateJobById(id, job);

        if(isUpdated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
