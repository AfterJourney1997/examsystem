package com.examSystem.service;

import com.examSystem.dao.TeacherMapper;
import com.examSystem.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherService(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public Teacher getTeacherByAccount(String account) {
        return teacherMapper.selectByAccount(account);
    }
}
