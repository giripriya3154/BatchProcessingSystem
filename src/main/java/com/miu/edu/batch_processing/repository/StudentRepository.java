package com.miu.edu.batch_processing.repository;

import com.miu.edu.batch_processing.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
