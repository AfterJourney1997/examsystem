package com.examSystem.service;

import com.examSystem.dao.AnswerMapper;
import com.examSystem.entity.Answer;
import com.examSystem.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnswerService {

    private final AnswerMapper answerMapper;

    @Autowired
    public AnswerService(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public List<Result> getStudentResult(String sAccount){
        return answerMapper.selectResult(sAccount);
    }
}
