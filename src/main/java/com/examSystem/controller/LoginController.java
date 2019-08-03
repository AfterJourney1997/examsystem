package com.examSystem.controller;

import com.examSystem.entity.*;
import com.examSystem.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller
@SessionAttributes(value = {"user", "school"})
public class LoginController {

    private final LoginService loginService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final ManagerService managerService;
    private final SchoolService schoolService;

    @Autowired
    public LoginController(LoginService loginService, StudentService studentService, TeacherService teacherService, ManagerService managerService, SchoolService schoolService) {
        this.loginService = loginService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.managerService = managerService;
        this.schoolService = schoolService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Model model, String username, String password, int identity) {

        log.info("用户登录，账号：" + username + "，密码：" +password + "，身份：" + identity);

        Login login = new Login();
        login.setIdentity(identity);
        login.setAccount(username);
        login.setPassword(password);

        Optional<Login> checkLogin = loginService.checkLogin(login);

        // 账号或密码错误
        if(!checkLogin.isPresent()){
            model.addAttribute("info", "账号或密码错误！");
            return new ModelAndView("login");
        }

        if(identity == 1){
            Student student = studentService.getStudentByAccount(checkLogin.get().getAccount());
            School school = schoolService.getSchoolById(student.getScId());
            model.addAttribute("user", student);
            model.addAttribute("school", school);
            log.info("学生登录：{}",student);
            return new ModelAndView("student");
        }

        if(identity == 2){
            Teacher teacher = teacherService.getTeacherByAccount(checkLogin.get().getAccount());
            School school = schoolService.getSchoolById(teacher.getScId());
            model.addAttribute("user", teacher);
            model.addAttribute("school", school);
            log.info("教师登录：{}",teacher);
            return new ModelAndView("teacher");
        }

        if(identity == 3){
            Manager manager = managerService.getManagerByAccount(checkLogin.get().getAccount());
            model.addAttribute("user", manager);
            log.info("管理员登录：{}",manager);
            return new ModelAndView("manager");
        }

        return new ModelAndView();

    }
}
