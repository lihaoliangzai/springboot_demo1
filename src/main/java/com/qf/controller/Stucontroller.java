package com.qf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.Servicer.IStuIServicer;
import com.qf.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 我也是最亮的仔
 */
@Controller
@RequestMapping("/stu")
public class Stucontroller {
@Autowired
private IStuIServicer stuIServicer;
/**
 * 功能描述: <br>
 * @Author: 深圳最靓的仔
 * @Param: [model]
 * @Return: java.lang.String
 * @Date: 2019/11/27 19:26
 */
@RequestMapping("/list")
    public String list(Model model){
    List<Student> list = stuIServicer.list();
    model.addAttribute("stu",list);
        return  "list";
    }
    /**
     * 功能描述: <br>
     * @Author: 深圳最靓的仔
     * @Param: []
     * @Return: java.lang.String
     * @Date: 2019/11/27 20:11
     */
    @RequestMapping("/add")
    public String a(){
        return "add";
    }
    /**
     * 功能描述: <br>
     * @Author: 深圳最靓的仔
     * @Param: [student]
     * @Return: com.qf.entity.Student
     * @Date: 2019/11/27 20:49
     */
    @RequestMapping("/ad")
    public String add(Student student){
        System.out.println(student);
        int result=stuIServicer.insert(student);
        return "redirect:/stu/list";
    }
    /**
     * 功能描述: <br>
     * @Author: 深圳最靓的仔
     * @Param:
     * @Return:
     * @Date: 2019/11/27 20:46
     */
    @RequestMapping("/del")
    public String del(Integer id){
        System.out.println(id);
        boolean b = stuIServicer.removeById(id);
        return "redirect:/stu/list";
    }
    /**
     * 功能描述: <br>
     * @Author: 深圳最靓的仔
     * @Param:
     * @Return:
     * @Date: 2019/11/27 21:30
     */
    @RequestMapping("/upd")
    public  String upd(Integer id,Model model){
        System.out.println("upd"+id);
        return "upda";
    }
    /**
     * 功能描述: <br>
     * @Author: 深圳最靓的仔
     * @Param:
     * @Return:
     * @Date: 2019/11/27 21:30
     */
    @RequestMapping("/upde")
    public  String upde(Integer id,Student student){
        System.out.println("upd"+id+student);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("student",student);
        stuIServicer.update(student,queryWrapper);
        return "/stu/list";
    }
}
