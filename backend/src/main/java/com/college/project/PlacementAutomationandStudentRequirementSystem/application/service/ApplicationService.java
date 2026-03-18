package com.college.project.PlacementAutomationandStudentRequirementSystem.application.service;

import com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto.ApplicationRequestDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto.ApplicationSummaryDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.util.ApiResponse;

import java.util.List;

public interface ApplicationService {
    ApiResponse<?> createApplication(ApplicationRequestDto applicationRequestDto);

    ApiResponse<List<ApplicationSummaryDto>> getAllApplications();
}
