package com.examSystem.controller;


import com.examSystem.entity.Answer;
import com.examSystem.entity.Login;
import com.examSystem.entity.Student;
import com.examSystem.entity.Student;
import com.examSystem.service.AnswerService;
import com.examSystem.service.StudentService;
import com.examSystem.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 这里配置默认可以打开的页面
 */
@Controller
public class TeacherController {
    @Resource
    AnswerService answerService;
    @Resource
    TeacherService ts;
    @Resource
    StudentService studentService;
    /**
     * 添加学生页面
     * @return
     */
    @RequestMapping({"/studentadd"})
    public String studentadd(){
        return "addstudent";
    }
    /**
     * 删除学生页面，获得全部学生
     * @return
     */
    @RequestMapping({"/studentdel"})
    public String studentdel(String scid,Model model){
        List<Student> stu = studentService.getAllStudentStudent(scid);
        model.addAttribute("stu",stu);
        return "delstudent";
    }
    /**
     * 查询学生页面
     * @return
     */
    @RequestMapping({"/studentsel"})
    public String studentsel(){
        return "selstudent";
    }
    /**
     * 查询学生信息
     * @return
     */
    @RequestMapping(value = "/selstudent")
    public String selstudent(String sid,Model model,HttpSession session){
        System.out.println(sid);
        List<Answer> stums =answerService.selstudent(sid);
        if(stums.size()<1)
        {
            Student student=studentService.getStudentByAccount(sid);

            model.addAttribute("stu",student);
            session.setAttribute("ms","该学生未参加考试");
            return "selstudentmg1";//学生没有参加考试则跳至此页面
        }else {
            model.addAttribute("stums",stums);
            return "selstudentmg";//学生参加考试则跳此页面
        }

    }
    /**
     * 添加学生
     * @return
     */
    @RequestMapping("/addstudent")
    public String addstudent(Student student, Model model){
        if(ts.addstudent(student)>0)
        {
            String out="添加成功,学生"+student.getSName()+"默认登录密码为“1234”";
            model.addAttribute("model",out);
        }else {
            model.addAttribute("model","添加失败");
        }
        return "addstudent";
    }
    /**
     * 删除学生
     * @return
     */
    @RequestMapping("/delstudent")
    public String delstudent(String sId,String scid,Model model){
        ts.delBysAccount(sId);
        List<Student> stu= studentService.getAllStudentStudent(scid);
        model.addAttribute("stu",stu);
        return "delstudent";
    }
    /**
     * 打开注册页
     * @return
     */
    @RequestMapping("/regPage.do")
    public String regPage(){
        return "UserReg";
    }
}
