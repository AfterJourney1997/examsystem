package com.examSystem.controller;

import cn.hutool.core.util.ArrayUtil;
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

import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/student")
@SessionAttributes(value = {"examInfo"})
public class StudentController {

    private final HttpServletRequest request;
    private final ArrangeService arrangeService;
    private final AnswerService answerService;
    private final TestService testService;
    private final ChoiceService choiceService;
    private final TrueFalseService trueFalseService;
    private final ShortAnswerService shortAnswerService;

    @Autowired
    public StudentController(HttpServletRequest request, ArrangeService arrangeService,
                             AnswerService answerService, TestService testService, ChoiceService choiceService,
                             TrueFalseService trueFalseService, ShortAnswerService shortAnswerService) {
        this.request = request;
        this.arrangeService = arrangeService;
        this.answerService = answerService;
        this.testService = testService;
        this.choiceService = choiceService;
        this.trueFalseService = trueFalseService;
        this.shortAnswerService = shortAnswerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String studentHomePage(){
        return "student/student";
    }

    @RequestMapping(value = "/examInfo", method = RequestMethod.GET)
    public ModelAndView getStudentExam(Model model) {

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        List<Arrange> arranges = arrangeService.getArrangeBySchool(student.getScId());
        log.info("查询考试：{}", arranges);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        model.addAttribute("dateTimeFormatter", dateTimeFormatter);
        model.addAttribute("exam", arranges);
        return new ModelAndView("student/examInfo");
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView getStudentResult(Model model) {

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        List<Result> studentResult = answerService.getStudentResult(student.getSAccount());
        log.info("查询成绩：{}", studentResult);
        model.addAttribute("result", studentResult);
        return new ModelAndView("student/result");
    }

    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public ModelAndView exam(Model model, int arrId, int testId) {

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        Arrange arrange = arrangeService.getArrange(arrId);
        Test test = testService.getTest(testId);
        log.info("考试信息：{}", arrange);
        // 获取选择题、判断题、简答题id
        String[] choices = test.getCqId().split("/");
        String[] trueFalses = test.getTfqId().split("/");
        String[] shortAnswers = test.getSaqId().split("/");

        List<Choice> choiceList = choiceService.getChoiceList(choices);
        List<TrueFalse> trueFalseList = trueFalseService.getTrueFalseList(trueFalses);
        List<ShortAnswer> shortAnswerList = shortAnswerService.getShortAnswerList(shortAnswers);

        model.addAttribute("examInfo", arrange);
        model.addAttribute("choice", choiceList);
        model.addAttribute("trueFalse", trueFalseList);
        model.addAttribute("shortAnswer", shortAnswerList);

        return new ModelAndView("student/exam");
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submitExam(String[] choiceList, String[] trueFalseList, String[] shortAnswerList) {

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        // 获取session中考试信息
        Object exam = request.getSession().getAttribute("exam");
        Arrange arrange = (Arrange)exam;

        String choices = ArrayUtil.join(choiceList, "/");
        String trueFalses = ArrayUtil.join(trueFalseList, "/");
        String shortAnswers = ArrayUtil.join(shortAnswerList, "/");

        Answer answer = new Answer(null, arrange.getArrId(), arrange.getTestId(), student.getSAccount(),
                student.getSName(), choices, trueFalses, null, shortAnswers);

        answerService.insertAnswer(answer);

        return new ModelAndView("student/finish");
    }

}
