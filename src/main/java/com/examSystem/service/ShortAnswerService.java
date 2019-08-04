package com.examSystem.service;

import com.examSystem.dao.ShortAnswerMapper;
import com.examSystem.entity.ShortAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShortAnswerService {

    private final ShortAnswerMapper shortAnswerMapper;

    @Autowired
    public ShortAnswerService(ShortAnswerMapper shortAnswerMapper) {
        this.shortAnswerMapper = shortAnswerMapper;
    }

    public List<ShortAnswer> getShortAnswerList(String[] shortAnswers){

        List<ShortAnswer> trueFalseList = new ArrayList<>();

        for (String shortAnswerId : shortAnswers){
            trueFalseList.add(shortAnswerMapper.selectByPrimaryKey(Integer.parseInt(shortAnswerId)));
        }

        return trueFalseList;
    }

}
