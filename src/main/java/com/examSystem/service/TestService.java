package com.examSystem.service;

import com.examSystem.dao.TestMapper;
import com.examSystem.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestMapper testMapper;

    @Autowired
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public Test getTest(int testId){
        return testMapper.selectByPrimaryKey(testId);
    }
}
