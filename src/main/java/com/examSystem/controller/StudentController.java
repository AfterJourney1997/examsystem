package com.examSystem.controller;

import com.examSystem.entity.Arrange;
import com.examSystem.entity.Result;
import com.examSystem.entity.Student;
import com.examSystem.service.AnswerService;
import com.examSystem.service.ArrangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {

    private final HttpServletRequest request;
    private final ArrangeService arrangeService;
    private final AnswerService answerService;

    @Autowired
    public StudentController(HttpServletRequest request, ArrangeService arrangeService, AnswerService answerService) {
        this.request = request;
        this.arrangeService = arrangeService;
        this.answerService = answerService;
    }

    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public ModelAndView getStudentExam(Model model) {

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        List<Arrange> arranges = arrangeService.getArrangeBySchool(student.getScId());
        log.info("查询考试：{}", arranges);
        model.addAttribute("exam", arranges);
        return new ModelAndView("student");
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView getStudentResult(Model model){

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        List<Result> studentResult = answerService.getStudentResult(student.getSAccount());
        log.info("查询成绩：{}", studentResult);
        model.addAttribute("result", studentResult);
        return new ModelAndView("student");
    }

}
