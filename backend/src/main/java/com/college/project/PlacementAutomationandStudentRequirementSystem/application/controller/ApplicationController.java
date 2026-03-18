package com.college.project.PlacementAutomationandStudentRequirementSystem.application.controller;

import com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto.ApplicationRequestDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto.ApplicationSummaryDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.application.service.impl.ApplicationServiceImpl;
import com.college.project.PlacementAutomationandStudentRequirementSystem.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationServiceImpl applicationService;


    @PostMapping
    public ResponseEntity<ApiResponse<?>> applyJob(@RequestBody ApplicationRequestDto applicationRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(applicationService.createApplication(applicationRequestDto));
    }

    //        @PutMapping("/{id}/status")
//        public ResponseEntity<?> updateStatus(){}
//
    @GetMapping
    public ResponseEntity<ApiResponse<List<ApplicationSummaryDto>>> getAllApplications() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(applicationService.getAllApplications());
    }
//        @DeleteMapping("/{id}")
//        public ResponseEntity<?> withdrawApplication(){}
//

}
