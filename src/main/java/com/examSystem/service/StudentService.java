package com.examSystem.service;

import com.examSystem.dao.StudentMapper;
import com.examSystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    //按学号查询学生
    public Student getStudentByAccount(String account) {
        return studentMapper.selectByAccount(account);
    }
    public List<Student> getAllStudentStudent(String scid){
        System.out.println(studentMapper.getAllSchoolStudent(scid)+"0000000"+scid);
        return studentMapper.getAllSchoolStudent(scid);

    }


}
