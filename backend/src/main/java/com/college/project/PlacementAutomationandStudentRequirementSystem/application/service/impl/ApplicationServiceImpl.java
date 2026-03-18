package com.college.project.PlacementAutomationandStudentRequirementSystem.application.service.impl;

import com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto.ApplicationRequestDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto.ApplicationSummaryDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.application.entity.Application;
import com.college.project.PlacementAutomationandStudentRequirementSystem.application.entity.util.ApplicationStatus;
import com.college.project.PlacementAutomationandStudentRequirementSystem.application.repository.ApplicationRepository;
import com.college.project.PlacementAutomationandStudentRequirementSystem.application.service.ApplicationService;
import com.college.project.PlacementAutomationandStudentRequirementSystem.exception.ResourceNotFoundException;
import com.college.project.PlacementAutomationandStudentRequirementSystem.job.entity.Job;
import com.college.project.PlacementAutomationandStudentRequirementSystem.job.repository.JobRepository;
import com.college.project.PlacementAutomationandStudentRequirementSystem.student.entity.Student;
import com.college.project.PlacementAutomationandStudentRequirementSystem.student.repository.StudentRepository;
import com.college.project.PlacementAutomationandStudentRequirementSystem.user.entity.User;
import com.college.project.PlacementAutomationandStudentRequirementSystem.user.repository.UserRepository;
import com.college.project.PlacementAutomationandStudentRequirementSystem.util.ApiResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JobRepository jobRepository;

    @Override
    @Transactional
    public ApiResponse<?> createApplication(ApplicationRequestDto applicationRequestDto) {

        // 1. get logged-in user{STUDENT}  (get student from dto for now)
        User student = userRepository.findById(applicationRequestDto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("User not exists"));
        // 2. get job
        Job job = jobRepository.findById(applicationRequestDto.getJobId())
                .orElseThrow(() -> new ResourceNotFoundException("Job not exists"));
        // 3. duplicate apply
        boolean exists = applicationRepository.existsByStudentAndJob(student, job);
        if(exists) {
                throw  new ResourceNotFoundException("Job not exists");
        }
        // 4. create new application
        Application application = new Application();
        application.setStudent(student);
        application.setJob(job);
        application.setStatus(ApplicationStatus.APPLIED);
        applicationRepository.save(application);
        return new ApiResponse<>("success", null);
    }

    @Override
    public ApiResponse<List<ApplicationSummaryDto>> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        List<ApplicationSummaryDto> dtoList = applications.stream()
                .map(application -> modelMapper.map(application, ApplicationSummaryDto.class))
                .toList();

        return new ApiResponse<>("Application fetch successfully", dtoList);
    }
}
