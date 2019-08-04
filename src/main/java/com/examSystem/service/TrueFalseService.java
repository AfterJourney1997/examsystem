package com.examSystem.service;

import com.examSystem.dao.TrueFalseMapper;
import com.examSystem.entity.TrueFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrueFalseService {

    private final TrueFalseMapper trueFalseMapper;

    @Autowired
    public TrueFalseService(TrueFalseMapper trueFalseMapper) {
        this.trueFalseMapper = trueFalseMapper;
    }

    public List<TrueFalse> getTrueFalseList(String[] trueFalses){

        List<TrueFalse> trueFalseList = new ArrayList<>();

        for (String trueFalseId : trueFalses){
            trueFalseList.add(trueFalseMapper.selectByPrimaryKey(Integer.parseInt(trueFalseId)));
        }

        return trueFalseList;
    }
}
