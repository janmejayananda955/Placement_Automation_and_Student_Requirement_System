package com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto;

import com.college.project.PlacementAutomationandStudentRequirementSystem.application.entity.util.ApplicationStatus;
import com.college.project.PlacementAutomationandStudentRequirementSystem.job.dto.JobResponseDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.student.dto.ApplicantDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDetailsDto {
    private UUID applicationId;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;

    private ApplicantDto student;
    private JobResponseDto jobResponseDto;
}
