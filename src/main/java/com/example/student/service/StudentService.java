package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String getStudent(){
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            return student.toString();
        }
        return "";
    }

    public String addStudent(Student student) {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setDob(student.getDob());
        studentRepository.save(student1);
        return "Student successfully created" + student1;
    }

    public void deleteStudent(Student student) {
        String name = student.getName();
        LocalDate dob = student.getDob();
        Student student1 = studentRepository.getStudent(name,dob);
        studentRepository.delete(student1);
    }
}

