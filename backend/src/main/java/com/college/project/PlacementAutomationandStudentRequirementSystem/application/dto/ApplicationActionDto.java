package com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto;

import com.college.project.PlacementAutomationandStudentRequirementSystem.application.entity.util.ApplicationStatus;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationActionDto {
    private UUID id;
    private ApplicationStatus currentStatus;
    private List<ApplicationStatus> allowedStatus;
}
