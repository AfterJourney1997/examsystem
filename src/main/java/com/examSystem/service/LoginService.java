package com.examSystem.service;

import com.examSystem.dao.LoginMapper;
import com.examSystem.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public Login checkLogin(Login login){

        List<Login> logins = loginMapper.selectByIdentity(login.getIdentity());

        Optional<Login> user = logins.stream()
                .filter((e) -> login.getAccount().equals(e.getAccount()) && login.getPassword().equals(e.getPassword()))
                .findFirst();

        return user.orElse(null);

    }

}
