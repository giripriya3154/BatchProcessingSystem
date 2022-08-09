package com.miu.edu.batch_processing.config.batch;

import com.miu.edu.batch_processing.entity.Student;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class StudentProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        if(student.getAge()<=0){
            return null;
        }
       return new Student(student.getId(),student.getFirst(),student.getLast(),
               student.getGpa(), student.getAge(), LocalDate.now().getYear()-student.getAge());

    }



}
