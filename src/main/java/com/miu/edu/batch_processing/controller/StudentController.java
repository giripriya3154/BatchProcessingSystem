package com.miu.edu.batch_processing.controller;


import com.miu.edu.batch_processing.entity.Student;
import com.miu.edu.batch_processing.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
   private StudentService studentService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public List<Student> user(){
        return studentService.getAllStudents();
    }

}
