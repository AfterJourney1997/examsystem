package com.examSystem.service;

import com.examSystem.dao.TestMapper;
import com.examSystem.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;

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
    //添加试卷
    public int inserttest(String testname, String Choice, String TrueFalse, String Short){
    Test test=new Test();
    test.setTestName(testname);
    test.setCqId(Choice);
    test.setTfqId(TrueFalse);
    test.setSaqId(Short);
    return testMapper.insert(test);
    }
}
