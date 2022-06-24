package com.lm.ssm.controller;

import com.lm.ssm.entity.Emp;
import com.lm.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Emp>  getAll(){
        System.out.println("134");
        return empService.getAll();
    }


}
