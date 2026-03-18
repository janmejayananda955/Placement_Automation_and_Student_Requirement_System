package com.college.project.PlacementAutomationandStudentRequirementSystem.job.controller;

import com.college.project.PlacementAutomationandStudentRequirementSystem.job.dto.JobRequestDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.job.dto.JobResponseDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.job.service.impl.JobServiceImpl;
import com.college.project.PlacementAutomationandStudentRequirementSystem.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobServiceImpl jobService;

    @PostMapping("{id}")
    public ResponseEntity<ApiResponse<?>> createJob(@PathVariable Long id ,@RequestBody JobRequestDto jobRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jobService.createJob(id,jobRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateJob(@PathVariable UUID id, @RequestBody JobRequestDto jobRequestDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(jobService.updateJobProfile(id,jobRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteJob(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(jobService.deleteJob(id));
    }

    @GetMapping
    public ResponseEntity<List<JobResponseDto>> getAllJobs(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDto> getJobById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(jobService.getJobById(id));
    }

}
