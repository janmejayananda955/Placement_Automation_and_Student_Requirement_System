package com.college.project.PlacementAutomationandStudentRequirementSystem.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterRequestDto {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Role is required")  // ← blocks request if role not sent, only allow student and recruiter
    @Pattern(regexp = "^(STUDENT|RECRUITER)$", message = "Invalid role")
    private String role;
}
