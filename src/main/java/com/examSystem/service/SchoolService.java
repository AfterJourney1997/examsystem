package com.examSystem.service;

import com.examSystem.dao.SchoolMapper;
import com.examSystem.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;

    @Autowired
    public SchoolService(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    public School getSchoolById(String schoolId){
        return schoolMapper.selectById(schoolId);
    }
}
