package com.miu.edu.batch_processing.service;


import com.miu.edu.batch_processing.entity.Student;
import com.miu.edu.batch_processing.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map((Student student) -> Student.builder()
                        .gpa(student.getGpa())
                        .first(student.getFirst())
                        .last(student.getLast())
                        .age(LocalDate.now().getYear() - student.getDob()).build())
                .collect(Collectors.toList());
    }
}
