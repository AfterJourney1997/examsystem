package com.examSystem.dao;

import com.examSystem.entity.Answer;
import com.examSystem.entity.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int delBysAccount(String Account);

    int insert(Answer record);

    Answer selectByPrimaryKey(Integer answerId);

    List<Answer> selectAll();

    int updateByPrimaryKey(Answer record);

    List<Answer> selectBySAccount(@Param("sAccount") String sAccount);

    List<Result> selectResult(@Param("sAccount") String sAccount);
}