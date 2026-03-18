package com.college.project.PlacementAutomationandStudentRequirementSystem.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//used for application model where recruiter see what they want to see not all
public class ApplicantDto {

    private Long studentId;
    private String name;
    private String email;
    private String phone;
    private List<String> skills;
    private Float cgpa;
    private String resumeUrl;
}
