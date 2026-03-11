package com.college.project.PlacementAutomationandStudentRequirementSystem.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {

    private int status;
    private String message;

}