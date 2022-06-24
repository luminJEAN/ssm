package com.lm.ssm.controller;

import com.lm.ssm.entity.Emp;
import com.lm.ssm.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/login", method = { RequestMethod.POST})
    public String login(String username, String password, HttpSession session, Model model){
        Emp emp = empService.getEmpInfo(username,password);
        if (emp != null) {
            session.setAttribute("loginUser",emp);
            System.out.println("loginUser = " + session.getAttribute("loginUser"));
//            return "redirect:/memorials/getAll";
            return "redirect:/memorials/getAllByPage?currentPage=1&size=10";
        } else {
            model.addAttribute("error","用户名或密码错误");

            return "index";
        }
    }

    @RequestMapping(value = "/register", method = { RequestMethod.POST })
    @ResponseBody
    public Map<String, Object> register(@RequestBody Map<String,Object> params){
        return empService.register(params);
    }

}
