package com.examSystem.service;

import com.examSystem.dao.ChoiceMapper;
import com.examSystem.entity.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChoiceService {

    private final ChoiceMapper choiceMapper;

    @Autowired
    public ChoiceService(ChoiceMapper choiceMapper) {
        this.choiceMapper = choiceMapper;
    }

    public List<Choice> getChoiceList(String[] choices){

        List<Choice> choiceList = new ArrayList<>();

        for(String choiceId : choices){
            choiceList.add(choiceMapper.selectByPrimaryKey(Integer.parseInt(choiceId)));
        }

        return choiceList;
    }
}
