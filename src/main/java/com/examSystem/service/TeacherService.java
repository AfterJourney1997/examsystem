package com.examSystem.service;

import com.examSystem.dao.AnswerMapper;
import com.examSystem.dao.LoginMapper;
import com.examSystem.dao.StudentMapper;
import com.examSystem.dao.TeacherMapper;
import com.examSystem.entity.Answer;
import com.examSystem.entity.Login;
import com.examSystem.entity.Student;
import com.examSystem.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class TeacherService {
    Login login=new Login();
    private final TeacherMapper teacherMapper;
    @Autowired
    AnswerMapper answerMapper;
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    public TeacherService(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public Teacher getTeacherByAccount(String account) {

        return teacherMapper.selectByAccount(account);
    }
    //添加学生，login表student表分别添加，默认密码1234
    public  int addstudent(Student student){
        login.setAccount(student.getSAccount());
        login.setIdentity(1);
        login.setPassword("1234");
        loginMapper.insert(login);
        return studentMapper.insert(student);
    }

    //删除学生,login,anser,student表中学生数据都会被删除
    public void delBysAccount(String sid){
        studentMapper.delBysAccount(sid);
        loginMapper.delBysAccount(sid);
        answerMapper.delBysAccount(sid);
    }
    //按学号查询学生
    public Student selectByAccount(String account){
        return studentMapper.selectByAccount(account);
    }
    //查询学生信息成绩answer表
    public List<Answer> selstudent(String account){
        return answerMapper.selectBySAccount(account);
    }
}
