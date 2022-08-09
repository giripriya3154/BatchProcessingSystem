package com.miu.edu.batch_processing.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Student {

    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "First")
    private String first;
    @Column(name = "Last")
    private String last;
    @Column(name = "GPA")
    private Double gpa;
    @Transient
    private Integer age;
    @Column(name = "DOB")
    private Integer dob;


}
