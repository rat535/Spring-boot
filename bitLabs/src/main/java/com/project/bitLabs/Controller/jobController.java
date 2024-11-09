package com.project.bitLabs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bitLabs.Dto.JobDto;
import com.project.bitLabs.service.JobService;

@RestController
@RequestMapping("/job")
public class jobController {

	@Autowired
	private JobService jobservice;

	@PostMapping("/{jobId}/apply/{userId}")
	public ResponseEntity<String> applyForJob(@PathVariable Long userId, @PathVariable Long jobId ) {
		try {
			boolean success = jobservice.applyForJob(jobId, userId);
			if (success) {
				return ResponseEntity.ok("Application submitted successfully.");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Application submission failed.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping("/")
	public ResponseEntity<JobDto> addJob(@RequestBody JobDto jobDto) {
		JobDto createdJob = jobservice.addJob(jobDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
	}

	@GetMapping("/{jobId}")
	public ResponseEntity<JobDto> getJobById(@PathVariable Long jobId) {
		JobDto job = jobservice.getJobById(jobId);
		return ResponseEntity.ok(job);
	}
	
	@PutMapping("/{jobId}")
    public ResponseEntity<JobDto> updateJob(@PathVariable Long jobId, @RequestBody JobDto updatedJob) {
        JobDto job = jobservice.updateJob(jobId, updatedJob);
        return ResponseEntity.ok(job);
    }

}
