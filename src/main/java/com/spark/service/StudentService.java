package com.spark.service;

import com.spark.annoatation.ReadAnno;
import com.spark.annoatation.WriteAnno;
import com.spark.mapper.StudentDao;
import com.spark.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tyd on 2018-1-15.
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @ReadAnno
    public List<Student> list() {
        return studentDao.list();
    }

    @WriteAnno
    public Integer insertStudent(Student student) {
        return studentDao.insert(student);
    }

}
