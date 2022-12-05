package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void getStudent(){
        studentRepository.findAll();
    }
    public void addStudent(Student student) {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setDob(student.getDob());
        studentRepository.save(student1);
    }
}

