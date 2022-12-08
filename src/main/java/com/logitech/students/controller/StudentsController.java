package com.logitech.students.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.logitech.students.model.Student;
import com.logitech.students.repository.StudentRepository;

@Controller
public class StudentsController {

    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping("/students")
    public String students(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("studentsList", students);
        return "students";
    }

    @PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

}
