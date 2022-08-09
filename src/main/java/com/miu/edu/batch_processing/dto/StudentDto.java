package com.miu.edu.batch_processing.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDto {
    private int id;
    private String first;
    private String last;
    private Double gpa;
    private Integer age;
}
