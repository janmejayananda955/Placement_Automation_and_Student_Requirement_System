package com.college.project.PlacementAutomationandStudentRequirementSystem.application.dto;

import com.college.project.PlacementAutomationandStudentRequirementSystem.application.entity.util.ApplicationStatus;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusRequestDto {
    private ApplicationStatus applicationStatus;
}
