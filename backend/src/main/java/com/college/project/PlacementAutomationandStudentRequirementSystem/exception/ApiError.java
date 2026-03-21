package com.college.project.PlacementAutomationandStudentRequirementSystem.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {

    private Boolean success;
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ApiError(int status, String message){
        this.success = false;
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();

    }
}