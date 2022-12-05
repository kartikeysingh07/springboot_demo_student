package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public void getStudent(){
        studentService.getStudent();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
}
