package com.examSystem.test;

import com.examSystem.dao.LoginMapper;
import com.examSystem.entity.Login;
import com.examSystem.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//------------
public class TranslationApplicationTests {

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private LoginService loginService;

    @Test
    public void contextLoads() {

        Login login = new Login();
        login.setAccount("student");
        login.setPassword("1234");
        login.setIdentity(1);

        Login user = loginService.checkLogin(login);
        System.out.println(user);

    }

}
