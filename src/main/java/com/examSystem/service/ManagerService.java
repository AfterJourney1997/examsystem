package com.examSystem.service;

import com.examSystem.dao.ManagerMapper;
import com.examSystem.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerMapper managerMapper;

    @Autowired
    public ManagerService(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    public Manager getManagerByAccount(String account) {
        return managerMapper.selectByAccount(account);
    }
}
