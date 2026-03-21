package com.college.project.PlacementAutomationandStudentRequirementSystem.auth.service;

import com.college.project.PlacementAutomationandStudentRequirementSystem.auth.dto.LoginRequestDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.auth.dto.LoginResponseDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.auth.dto.RegisterRequestDto;
import com.college.project.PlacementAutomationandStudentRequirementSystem.util.ApiResponse;

import java.util.List;


public interface AuthService {

    ApiResponse<?> registerUser(RegisterRequestDto loginRequestDto);

    ApiResponse<LoginResponseDto> loginUser(LoginRequestDto loginRequestDto);

    List<?> getRoles();
}
