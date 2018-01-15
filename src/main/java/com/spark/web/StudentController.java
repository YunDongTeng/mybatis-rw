package com.spark.web;

import com.spark.model.Student;
import com.spark.result.Result;
import com.spark.result.ResultEnum;
import com.spark.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tyd on 2018-1-15.
 *
 * @author tyd
 */

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> list() {
        return studentService.list();
    }

    @PostMapping("/insert")
    public Integer insert(Student student) {
        return studentService.insertStudent(student);

    }

}
