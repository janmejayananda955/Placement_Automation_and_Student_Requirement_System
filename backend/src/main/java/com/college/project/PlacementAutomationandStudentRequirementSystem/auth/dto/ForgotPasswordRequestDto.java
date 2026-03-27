package com.college.project.PlacementAutomationandStudentRequirementSystem.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequestDto {
    @NotEmpty(message = "Email required")
    @Email(message = "Email must be valid")
    private String email;
}
