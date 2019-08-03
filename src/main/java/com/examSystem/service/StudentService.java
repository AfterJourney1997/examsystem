package com.examSystem.service;

import com.examSystem.dao.StudentMapper;
import com.examSystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student getStudentByAccount(String account) {
        return studentMapper.selectByAccount(account);
    }
}
