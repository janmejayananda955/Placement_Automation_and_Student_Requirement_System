package com.college.project.PlacementAutomationandStudentRequirementSystem.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required") //set format
    @Pattern(regexp = "^.{8,}$", message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Role is required")  // ← blocks request if role not sent, only allow student and recruiter
    @Pattern(regexp = "^(STUDENT|RECRUITER)$", message = "Invalid role")
    private String role;

}
