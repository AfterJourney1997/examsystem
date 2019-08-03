package com.examSystem.dao;

import com.examSystem.entity.student;
import java.util.List;

public interface studentMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(student record);

    student selectByPrimaryKey(Integer sId);

    List<student> selectAll();

    int updateByPrimaryKey(student record);
}